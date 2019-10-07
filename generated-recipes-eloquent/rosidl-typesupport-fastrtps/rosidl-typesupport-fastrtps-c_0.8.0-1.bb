# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Generate the C interfaces for eProsima FastRTPS."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
ROS_AUTHOR = "Ricardo González"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rosidl_typesupport_fastrtps"
ROS_BPN = "rosidl_typesupport_fastrtps_c"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    fastcdr-native \
    fastrtps-cmake-module-native \
    fastrtps-native \
    rosidl-cmake-native \
    rosidl-generator-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"

ROS_EXPORT_DEPENDS = " \
    rmw \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    ament-cmake-native \
    fastcdr-native \
    fastrtps-cmake-module-native \
    fastrtps-native \
    rosidl-cmake-native \
    rosidl-generator-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"

ROS_EXEC_DEPENDS = " \
    rosidl-parser \
    rosidl-typesupport-interface \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/rosidl_typesupport_fastrtps-release/archive/release/eloquent/rosidl_typesupport_fastrtps_c/0.8.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5daa1affaabe0da3f28169e0f15840cf"
SRC_URI[sha256sum] = "4cc0ba2549cb232f0e1b5b890baa75524db15fafbc567b552b9da82d53fcf0ce"
S = "${WORKDIR}/rosidl_typesupport_fastrtps-release-release-eloquent-rosidl_typesupport_fastrtps_c-0.8.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rosidl-typesupport-fastrtps', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rosidl-typesupport-fastrtps', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosidl-typesupport-fastrtps/rosidl-typesupport-fastrtps_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosidl-typesupport-fastrtps/rosidl-typesupport-fastrtps-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosidl-typesupport-fastrtps/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosidl-typesupport-fastrtps/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
