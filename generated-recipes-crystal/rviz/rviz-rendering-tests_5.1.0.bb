# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Example plugin for RViz - documents and tests RViz plugin development"
AUTHOR = "William Woodall <william@osrfoundation.org>"
HOMEPAGE = "https://github.com/ros2/rviz"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=01c2bc31767ccb3a68e12f02612b2a97"

ROS_CN = "rviz"
ROS_BPN = "rviz_rendering_tests"

ROS_BUILD_DEPENDS = " \
    qtbase \
    resource-retriever \
    rviz-rendering \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    resource-retriever \
    rviz-rendering \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    resource-retriever \
    rviz-rendering \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-cppcheck \
    ament-cmake-cpplint \
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-cmake-lint-cmake \
    ament-cmake-uncrustify \
    ament-index-cpp \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/rviz-release/archive/release/crystal/rviz_rendering_tests/5.1.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2f1df27036fd46a985b943c98a955fcc"
SRC_URI[sha256sum] = "a66b2482a4c5c7ab5fd51246a799b42855b7d406643a9c28e1eff45fbadeb3e1"
S = "${WORKDIR}/rviz-release-release-crystal-rviz_rendering_tests-5.1.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rviz', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rviz', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rviz/rviz_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rviz/rviz-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rviz/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rviz/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
