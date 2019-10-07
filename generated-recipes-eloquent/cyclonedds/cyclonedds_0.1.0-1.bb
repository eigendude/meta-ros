# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Eclipse Cyclone DDS is a very performant and robust open-source DDS implementation. Cyclone DDS is developed completely in the open as an Eclipse IoT project."
AUTHOR = "Eclipse Foundation, Inc. <cyclonedds-dev@eclipse.org>"
HOMEPAGE = "https://projects.eclipse.org/projects/iot.cyclonedds"
SECTION = "devel"
LICENSE = "Eclipse-Public-License-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=7532470dee289492e850d7d3e8a32b32"

ROS_CN = "cyclonedds"
ROS_BPN = "cyclonedds"

ROS_BUILD_DEPENDS = " \
    openssl \
"

ROS_BUILDTOOL_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_java-native} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_maven-native} \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    openssl \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    openssl \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libcunit-dev} \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/cyclonedds-release/archive/release/eloquent/cyclonedds/0.1.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b8c18b8b0a4f415beacf983a777b452d"
SRC_URI[sha256sum] = "55165e8309299ae942fc02b03b65e2e68eb2a0c9ef4c816adba96645472299c7"
S = "${WORKDIR}/cyclonedds-release-release-eloquent-cyclonedds-0.1.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('cyclonedds', d)}"
ROS_BUILD_TYPE = "cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('cyclonedds', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cyclonedds/cyclonedds_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cyclonedds/cyclonedds-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cyclonedds/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cyclonedds/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
