# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The joint_trajectory_action is a node that exposes an action interface      to a joint trajectory controller."
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Stuart Glaser"
HOMEPAGE = "http://ros.org/wiki/joint_trajectory_action"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_controllers"
ROS_BPN = "joint_trajectory_action"

ROS_BUILD_DEPENDS = " \
    actionlib \
    pr2-controllers-msgs \
    roscpp \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    pr2-controllers-msgs \
    roscpp \
    trajectory-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    pr2-controllers-msgs \
    roscpp \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_controllers-release/archive/release/melodic/joint_trajectory_action/1.10.17-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/joint_trajectory_action"
SRC_URI = "git://github.com/pr2-gbp/pr2_controllers-release;${ROS_BRANCH};protocol=https"
SRCREV = "8873d551e2e36b32935f8ba7205628e54cd9e671"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('pr2-controllers', d)}"
ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
