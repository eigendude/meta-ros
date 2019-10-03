# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Multi-master tools for configuration and message relaying"
AUTHOR = "Paul Bovbel <pbovbel@clearpath.ai>"
ROS_AUTHOR = "Paul Bovbel <pbovbel@clearpath.ai>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "cpr_multimaster_tools"
ROS_BPN = "cpr_multimaster_tools"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    clock-relay \
    message-relay \
    multimaster-launch \
    multimaster-msgs \
    tf2-relay \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/clearpath-gbp/cpr_multimaster_tools-release/archive/release/melodic/cpr_multimaster_tools/0.0.2-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "20d855b89b8f8ca00cbfb03243857269"
SRC_URI[sha256sum] = "4146b715489ee0a3271fe50e568ad19197b7f30c51bb7539cdee47cc0b8c5d32"
S = "${WORKDIR}/cpr_multimaster_tools-release-release-melodic-cpr_multimaster_tools-0.0.2-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('cpr-multimaster-tools', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('cpr-multimaster-tools', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cpr-multimaster-tools/cpr-multimaster-tools_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cpr-multimaster-tools/cpr-multimaster-tools-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cpr-multimaster-tools/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cpr-multimaster-tools/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
