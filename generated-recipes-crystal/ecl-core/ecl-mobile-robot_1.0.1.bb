# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Contains transforms (e.g. differential drive inverse kinematics)     for the various types of mobile robot platforms."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/ecl_mobile_robot"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ecl_core"
ROS_BPN = "ecl_mobile_robot"

ROS_BUILD_DEPENDS = " \
    ecl-build \
    ecl-errors \
    ecl-formatters \
    ecl-geometry \
    ecl-license \
    ecl-linear-algebra \
    ecl-math \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ecl-build \
    ecl-errors \
    ecl-formatters \
    ecl-geometry \
    ecl-license \
    ecl-linear-algebra \
    ecl-math \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/yujinrobot-release/ecl_core-release/archive/release/crystal/ecl_mobile_robot/1.0.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b35ded77b1d4580f372e6b03a5d2ba24"
SRC_URI[sha256sum] = "6f5823539daecf82dd626c3bb0737a5e86d5726019d272171217fd7115890500"
S = "${WORKDIR}/ecl_core-release-release-crystal-ecl_mobile_robot-1.0.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ecl-core', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ecl-core', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecl-core/ecl-core_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecl-core/ecl-core-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecl-core/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecl-core/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
