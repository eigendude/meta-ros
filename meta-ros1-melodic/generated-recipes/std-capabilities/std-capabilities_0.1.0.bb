# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package contains standard capability interfaces, which describe common robot capabilities in terms of ROS concepts such as topics, services, actions, and parameters."
AUTHOR = "William Woodall <william@osrfoundation.org>"
ROS_AUTHOR = "William Woodall <william@osrfoundation.org>"
HOMEPAGE = "http://ros.org/wiki/std_capabilities"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "std_capabilities"
ROS_BPN = "std_capabilities"

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

# matches with: https://github.com/ros-gbp/std_capabilities-release/archive/release/melodic/std_capabilities/0.1.0-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/std_capabilities"
SRC_URI = "git://github.com/ros-gbp/std_capabilities-release;${ROS_BRANCH};protocol=https"
SRCREV = "b3ce4780053beaf904c72a588fb9fe1aa90cad0e"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('std-capabilities', d)}"
ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
