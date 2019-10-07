# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The entry point package to launch testing in ROS."
AUTHOR = "Michel Hidalgo <michel@ekumenlabs.com>"
ROS_AUTHOR = "Michel Hidalgo <michel@ekumenlabs.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ros_testing"
ROS_BPN = "ros_testing"

ROS_BUILD_DEPENDS = " \
    ament-cmake-core \
    ament-cmake-export-dependencies \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    launch-testing \
    launch-testing-ament-cmake \
    launch-testing-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    launch-testing-ament-cmake-native \
    ros2test-native \
"

ROS_EXEC_DEPENDS = " \
    launch-testing \
    launch-testing-ros \
    ros2test \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/ros_testing-release/archive/release/eloquent/ros_testing/0.2.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f20b5895d7c07f9c26b2db6354f66927"
SRC_URI[sha256sum] = "c0b0642a8359f6dcd4c36e05381165b79408a639d8621c482b8c09d98f9f3c4f"
S = "${WORKDIR}/ros_testing-release-release-eloquent-ros_testing-0.2.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ros-testing', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ros-testing', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-testing/ros-testing_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-testing/ros-testing-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-testing/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros-testing/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
