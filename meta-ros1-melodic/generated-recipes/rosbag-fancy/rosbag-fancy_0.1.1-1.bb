# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "rosbag with terminal UI"
AUTHOR = "Max Schwarz <max.schwarz@uni-bonn.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=5;endline=5;md5=75730354549103aaba72b66caf53717b"

ROS_CN = "rosbag_fancy"
ROS_BPN = "rosbag_fancy"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libncurses-dev} \
    boost \
    rosbag-storage \
    roscpp \
    rosfmt \
    topic-tools \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libncurses-dev} \
    boost \
    rosbag-storage \
    roscpp \
    rosfmt \
    topic-tools \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libncurses-dev} \
    boost \
    rosbag-storage \
    roscpp \
    rosfmt \
    topic-tools \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/xqms/rosbag_fancy-release/archive/release/melodic/rosbag_fancy/0.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rosbag_fancy"
SRC_URI = "git://github.com/xqms/rosbag_fancy-release;${ROS_BRANCH};protocol=https"
SRCREV = "2a68552a54135e6dd26004b02d0d6b8d93477931"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
