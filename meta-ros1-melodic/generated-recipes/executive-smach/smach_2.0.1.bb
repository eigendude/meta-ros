# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "SMACH is a task-level architecture for rapidly creating complex robot     behavior. At its core, SMACH is a ROS-independent Python library to build     hierarchical state machines. SMACH is a new library that takes advantage of     very old concepts in order to quickly create robust robot behavior with     maintainable and modular code."
AUTHOR = "Isaac I. Y. Saito <gm130s@gmail.com>"
ROS_AUTHOR = "Jonathan Bohren"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "executive_smach"
ROS_BPN = "smach"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/executive_smach-release/archive/release/melodic/smach/2.0.1-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/smach"
SRC_URI = "git://github.com/ros-gbp/executive_smach-release;${ROS_BRANCH};protocol=https"
SRCREV = "836c2c3b6109c58762520ecd237746baf40fae02"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('executive-smach', d)}"
ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
