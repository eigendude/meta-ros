# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "API and scripts to parse .msg/.srv/.action files and convert them to .idl."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rosidl"
ROS_BPN = "rosidl_adapter"

ROS_BUILD_DEPENDS = " \
    ament-cmake \
    ament-cmake-export-definitions \
    ament-cmake-export-include-directories \
    ament-cmake-export-interfaces \
    ament-cmake-export-libraries \
    ament-cmake-export-link-flags \
    ament-cmake-include-directories \
    ament-cmake-libraries \
    ament-cmake-python \
    ament-cmake-target-dependencies \
    ament-cmake-test \
    python3 \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-package-native \
    python3-catkin-pkg-native \
    python3-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-package \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    ament-package-native \
"

ROS_EXEC_DEPENDS = " \
    python3-empy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-pytest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/rosidl-release/archive/release/eloquent/rosidl_adapter/0.8.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ac399245122853ae02e4fb3a53703cd1"
SRC_URI[sha256sum] = "79b6d04f66f2d26b970d829f603c41df6a8d3109a7829deee3a87b50f2287f4a"
S = "${WORKDIR}/rosidl-release-release-eloquent-rosidl_adapter-0.8.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rosidl', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rosidl', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosidl/rosidl_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosidl/rosidl-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosidl/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosidl/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
