# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Metapackage for Clearpath Husky robot software"
AUTHOR = "Paul Bovbel <paul@bovbel.com>"
HOMEPAGE = "http://ros.org/wiki/husky_robot"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "husky"
ROS_BPN = "husky_robot"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    husky-base \
    husky-bringup \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    husky-base \
    husky-bringup \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/clearpath-gbp/husky-release/archive/release/melodic/husky_robot/0.4.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c97c6e08db574093298601b2173d3de0"
SRC_URI[sha256sum] = "59397d25ee22b8f1a8795bf849cbe12d4d7ab6d2ffc294b21ec6442fc8e0852e"
S = "${WORKDIR}/husky-release-release-melodic-husky_robot-0.4.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('husky', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('husky', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/husky/husky_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/husky/husky-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/husky/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/husky/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
