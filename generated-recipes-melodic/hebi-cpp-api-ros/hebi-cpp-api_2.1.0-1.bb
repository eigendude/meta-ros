# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A ROS package providing access to the HEBI C++ API."
AUTHOR = "Matthew Tesch <matt@hebirobotics.com>"
ROS_AUTHOR = "Matthew Tesch <matt@hebirobotics.com>"
HOMEPAGE = "http://docs.hebi.us/tools.html#cpp-api"
SECTION = "devel"
LICENSE = "HEBI-C-Software-License-https-www.hebirobotics.com-softwarelicense-"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=8cc38e87392e4480a4870daca61af5fd"

ROS_CN = "hebi_cpp_api_ros"
ROS_BPN = "hebi_cpp_api"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    libeigen \
"

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

SRC_URI = "https://github.com/HebiRobotics/hebi_cpp_api_ros-release/archive/release/melodic/hebi_cpp_api/2.1.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8fcb0e87ce4dbfae1272a5bcfcfb63d3"
SRC_URI[sha256sum] = "c322cc89c65900c9357d451a53ec0c9d301954de10bca9ff3c85da20d6c5c5db"
S = "${WORKDIR}/hebi_cpp_api_ros-release-release-melodic-hebi_cpp_api-2.1.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('hebi-cpp-api-ros', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('hebi-cpp-api-ros', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/hebi-cpp-api-ros/hebi-cpp-api-ros_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/hebi-cpp-api-ros/hebi-cpp-api-ros-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/hebi-cpp-api-ros/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/hebi-cpp-api-ros/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
