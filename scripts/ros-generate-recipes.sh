# /bin/sh (deliberately no !#)
#
# Usage: cd meta-ros
#        [SUPERFLORE_GEN_OE_RECIPES=/path/to/superflore-gen-oe-recipes] sh scripts/ros-generate-recipes.sh ROS_DISTRO [ROS_PKG1 ROS_PKG2 ...]
#        (current branch is now superflore/DATETIME)
#            or
#        sh scripts/ros-generate-recipes.sh --version
#
#        Generate (or re-generate) recipes for the ROS_DISTRO from the existing ROS_DISTRO/cache.yaml. If no ROS_PKG arguments are given,
#        then all of the recipes for ROS_DISTRO are generated.
#
# This script will abort if Git detects any uncommitted modifications, eg, from a previous run that did not complete or untracked
# files (which would otherwise appear in files/ROS_DISTRO/superflore-change-summary.txt).
#
# Copyright (c) 2019 LG Electronics, Inc.

readonly SCRIPT_NAME="ros-generate-recipes"
readonly SCRIPT_VERSION="1.0.0"

# Files under ros/rosdistro/rosdep that we care about. Keep in sync with setting in ros-generate-cache.sh .
readonly ROSDEP_YAML_BASENAMES="base python ruby"

usage() {
    echo "Usage: cd meta-ros"
    echo "       [SUPERFLORE_GEN_OE_RECIPES=/path/to/superflore-gen-oe-recipes] sh scripts/$SCRIPT_NAME.sh ROS_DISTRO [ROS_PKG1 ROS_PKG2 ...]"
    echo "               or"
    echo "       sh scripts/$SCRIPT_NAME.sh --version"
    exit 1
}

if [ "$1" = "--version" ]; then
    echo "$SCRIPT_NAME $SCRIPT_VERSION"
    exit
fi

[ $# -eq 0 ] && usage

[ -z "$SUPERFLORE_GEN_OE_RECIPES" ] && SUPERFLORE_GEN_OE_RECIPES=$(which superflore-gen-oe-recipes)
if [ -z "$SUPERFLORE_GEN_OE_RECIPES" ]; then
    echo "ABORT: superflore-gen-oe-recipes not found"
    exit
fi

ROS_DISTRO=$1
# ROS_VERSION and ROS_PYTHON_VERSION must be in the environment as they appear in "conditional" attributes. Keep this block in
# sync with the one in ros-generate-cache.sh .
case $ROS_DISTRO in
    "kinetic"|"melodic")
        export ROS_VERSION="1"
        export ROS_PYTHON_VERSION="2"
        ;;

    "crystal"|"dashing")
        export ROS_VERSION="2"
        export ROS_PYTHON_VERSION="3"
        ;;

    *)  echo "ABORT: Unrecognized ROS_DISTRO: $ROS_DISTRO"
        exit 1
        ;;
esac

only_option=""
if [ $# -gt 1 ]; then
    shift
    only_option="--only $*"
fi

if [ -n "$(git status --porcelain=v1)" ]; then
    echo "ABORT: Uncommitted modifications detected by Git -- perhaps invoke 'git reset --hard'?"
    exit 1
fi

if [ ! -f files/$ROS_DISTRO/cache.yaml ]; then
    echo "ABORT: files/$ROS_DISTRO/cache.yaml doesn't exist -- run ros-generate-cache.sh to create it"
    exit 1
fi

if [ ! -f files/$ROS_DISTRO/index-v4.yaml ]; then
    echo "ABORT: files/$ROS_DISTRO/index-v4.yaml doesn't exist -- run ros-generate-cache.sh to create it"
    exit 1
fi

set -- $(head -n 1 files/$ROS_DISTRO/cache.yaml)
ROS_DISTRO_RELEASE_DATE=$3
ROS_ROSDISTRO_COMMIT=$4
ROS_ROSDISTRO_COMMIT_DATETIME=$5

if [ -z "$ROS_DISTRO_RELEASE_DATE" -o -z "$ROS_ROSDISTRO_COMMIT" -o -z "$ROS_ROSDISTRO_COMMIT_DATETIME" ] ; then
    echo "ABORT: files/$ROS_DISTRO/cache.yaml should start with '# $ROS_DISTRO/cache.yaml' and 3 space separated values:"
    echo "       ROS_DISTRO_RELEASE_DATE, ROS_ROSDISTRO_COMMIT, ROS_ROSDISTRO_COMMIT_DATETIME. Run ros-generate-cache.sh to"
    echo "       re-create it."
    exit 1
fi

# Keep this block in sync with the one in ros-generate-cache.sh .
case $ROS_DISTRO_RELEASE_DATE in
    pre-release|[2-9][0-9][0-9][0-9][0-1][0-9][0-3][0-9])
        : OK
        ;;

    *)  echo "ABORT: ROS_DISTRO_RELEASE_DATE not YYYYMMDD or 'pre-release': '$ROS_DISTRO_RELEASE_DATE'"
        exit 1
        ;;
esac


abort=false
for f in $ROSDEP_YAML_BASENAMES; do
    ff=$(sed -n "\@^yaml file:/.*/$f.yaml\$@ s@.*file://@@p" /etc/ros/rosdep/sources.list.d/20-default.list)
    # -q reports when they differ.
    diff -q files/$ROS_DISTRO/rosdep/$f.yaml $ff || abort=true
done
unset f ff
if $abort; then
    echo "ABORT: The files pointed to by /etc/ros/rosdep/sources.list.d/20-default.list must match those under files/$ROS_DISTRO/rosdep"
    exit 1
fi
unset abort

# Done checking things.

skip_keys_option=""
ros1_lisp_packages="euslisp geneus genlisp roslisp actionlib_lisp cl_tf cl_tf2 cl_transforms cl_transforms_stamped cl_urdf cl_utils roslisp_common roslisp_utilities rosemacs ros_emacs_utils roslisp_repl slime_ros slime_wrapper"
case $ROS_DISTRO in
    "kinetic")
        skip_keys_option="--skip-keys catkin_virtualenv flatbuffers grpc nanomsg octovis rosdoc_lite"
        skip_keys_option="$skip_keys_option $ros1_lisp_packages"
        ;;

    "melodic")
        skip_keys_option="--skip-keys catkin_virtualenv flatbuffers iirob_filters grpc nanomsg octovis rosdoc_lite"
        skip_keys_option="$skip_keys_option $ros1_lisp_packages"
        ;;

    *)  : Nothing is skipped for "crystal" and "dashing".
        ;;
esac

# Keep this block in sync with the one in ros-generate-cache.sh .
echo "Running 'rosdep update'"
rosdep update || { echo "ABORT: 'rosdep update' failed"; exit 1; }
echo "'rosdep update' finished"

tmpdir=$(mktemp -t -d ros-generate-recipes-XXXXXXXX)
trap "rm -rf $tmpdir" 0

cp files/$ROS_DISTRO/index-v4.yaml $tmpdir/
sed -i -e "/$ROS_DISTRO-cache.yaml.gz/ s@: .*\$@: file://$PWD/files/$ROS_DISTRO/cache.yaml@" $tmpdir/index-v4.yaml

# Tell superflore to use this index instead of the upstream one.
export ROSDISTRO_INDEX_URL="file://$tmpdir/index-v4.yaml"
# Have it use this date instead of "now".
export SUPERFLORE_GENERATION_DATETIME="$ROS_ROSDISTRO_COMMIT_DATETIME"

before_commit=$(git rev-list -1 HEAD)
$SUPERFLORE_GEN_OE_RECIPES --dry-run --ros-distro $ROS_DISTRO --output-repository-path . --upstream-branch HEAD \
                            $skip_keys_option $only_option

after_commit=$(git rev-list -1 HEAD)
if [ $after_commit != $before_commit -a -z "$only_option" ]; then
    # XXX Pretend that superflore has already been fixed not to generate files/ROS_DISTRO/cache.* and delete the comment line it
    # prepends. (The line ends with the filename.)
    sed -i -e '/^#.*cache[.]yaml$/ d' files/$ROS_DISTRO/cache.yaml
    sed -i -e '/^#.*cache[.]diffme$/ d' files/$ROS_DISTRO/cache.diffme
    git add files/$ROS_DISTRO/cache.yaml files/$ROS_DISTRO/cache.diffme

    generated="conf/ros-distro/include/$ROS_DISTRO/generated-ros-distro.inc"
    [ $ROS_DISTRO_RELEASE_DATE = "pre-release" ] && ROS_DISTRO_RELEASE_DATE=""
    cat <<! >> $generated

# From the release announcement or the last field of the "release-ROS_DISTRO-YYYYMMDD" tag for the release in
# https://github.com/ros2/ros2/releases. Prior to the first release of a ROS_DISTRO, it is set to "".
ROS_DISTRO_RELEASE_DATE = "$ROS_DISTRO_RELEASE_DATE"

# The commit of ros/rosdistro/$ROS_DISTRO/distribution.yaml from which the recipes were generated.
ROS_SUPERFLORE_GENERATION_COMMIT = "$ROS_ROSDISTRO_COMMIT"
!
    git add $generated
    git commit --amend -q -C HEAD

    unset generated
fi
