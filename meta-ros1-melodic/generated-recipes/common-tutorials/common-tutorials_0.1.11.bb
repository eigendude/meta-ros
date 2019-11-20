# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Metapackage that contains common tutorials"
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/common_tutorials"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "common_tutorials"
ROS_BPN = "common_tutorials"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib-tutorials \
    nodelet-tutorial-math \
    pluginlib-tutorials \
    turtle-actionlib \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib-tutorials \
    nodelet-tutorial-math \
    pluginlib-tutorials \
    turtle-actionlib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/common_tutorials-release/archive/release/melodic/common_tutorials/0.1.11-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/common_tutorials"
SRC_URI = "git://github.com/ros-gbp/common_tutorials-release;${ROS_BRANCH};protocol=https"
SRCREV = "88a92c73e544b8a1b27b9fa4569e05bd72e278bc"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('common-tutorials', d)}"
ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
