# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "A 2D navigation stack that takes in information from odometry, sensor         streams, and a goal pose and outputs safe velocity commands that are sent         to a mobile base."
AUTHOR = "Michael Ferguson <mfergs7@gmail.com>"
ROS_AUTHOR = "contradict@gmail.com"
HOMEPAGE = "http://wiki.ros.org/navigation"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=2988eb2faff9dfbcfa1c72a9efc3fa78"

ROS_CN = "navigation"
ROS_BPN = "navigation"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    amcl \
    base-local-planner \
    carrot-planner \
    clear-costmap-recovery \
    costmap-2d \
    dwa-local-planner \
    fake-localization \
    global-planner \
    map-server \
    move-base \
    move-base-msgs \
    move-slow-and-clear \
    nav-core \
    navfn \
    rotate-recovery \
    voxel-grid \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/navigation-release/archive/release/melodic/navigation/1.16.5-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/navigation"
SRC_URI = "git://github.com/ros-gbp/navigation-release;${ROS_BRANCH};protocol=https"
SRCREV = "f3ed94cab6ca364450c294826f173fd30c54cb47"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
