# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Examples of minimal subscribers"
AUTHOR = "Jacob Perron <jacob@openrobotics.org>"
ROS_AUTHOR = "Mikael Arguedas"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "examples"
ROS_BPN = "examples_rclcpp_minimal_subscriber"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/examples-release/archive/release/eloquent/examples_rclcpp_minimal_subscriber/0.8.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c516067bc04d6997f8ed070b930de1ff"
SRC_URI[sha256sum] = "741cdefe0aeab3090c14683362f9048567905436e5c94263a9f774d523f88866"
S = "${WORKDIR}/examples-release-release-eloquent-examples_rclcpp_minimal_subscriber-0.8.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('examples', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('examples', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/examples/examples_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/examples/examples-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/examples/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/examples/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
