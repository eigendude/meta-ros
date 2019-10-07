# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The package provides GoogleMock."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "googletest"
ROS_BPN = "gmock_vendor"

ROS_BUILD_DEPENDS = " \
    cmake \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    gtest-vendor \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/googletest-release/archive/release/eloquent/gmock_vendor/1.8.9000-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e0a01a14aa1c1be8f2328a9c3b3559c0"
SRC_URI[sha256sum] = "a9b45aa951486d246bc6081f3d48d20cf8fa468e081ecc72afb4db824004117a"
S = "${WORKDIR}/googletest-release-release-eloquent-gmock_vendor-1.8.9000-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('googletest', d)}"
ROS_BUILD_TYPE = "cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('googletest', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/googletest/googletest_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/googletest/googletest-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/googletest/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/googletest/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
