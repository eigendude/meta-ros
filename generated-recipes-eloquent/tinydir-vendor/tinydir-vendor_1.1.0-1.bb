# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "CMake shim over tinydir: https://github.com/cxong/tinydir/"
AUTHOR = "AWS RoboMaker <ros-contributions@amazon.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "tinydir_vendor"
ROS_BPN = "tinydir_vendor"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
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

SRC_URI = "https://github.com/ros2-gbp/tinydir_vendor-release/archive/release/eloquent/tinydir_vendor/1.1.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d35ed7f6dd702e46e775bcc51da9bea2"
SRC_URI[sha256sum] = "2dff2ccf7e3861d510c46975bdd4e7699f9f52d6ddf356475e6e96b96629f10c"
S = "${WORKDIR}/tinydir_vendor-release-release-eloquent-tinydir_vendor-1.1.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('tinydir-vendor', d)}"
ROS_BUILD_TYPE = "cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('tinydir-vendor', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/tinydir-vendor/tinydir-vendor_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/tinydir-vendor/tinydir-vendor-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/tinydir-vendor/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/tinydir-vendor/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
