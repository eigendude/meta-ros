# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The pilz_extensions package. Here are classes extending the functionality of other packages.   On the long run these extensions should become pull requests on the respective packages."
AUTHOR = "Alexander Gutenkunst <a.gutenkunst@pilz.de>"
HOMEPAGE = "https://wiki.ros.org/pilz_extensions"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "pilz_industrial_motion"
ROS_BPN = "pilz_extensions"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_clang-tidy} \
    joint-limits-interface \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    joint-limits-interface \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joint-limits-interface \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    code-coverage \
    prbt-support \
    rostest \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/PilzDE/pilz_industrial_motion-release/archive/release/melodic/pilz_extensions/0.4.5-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "aaf89e3be42cad2dabd26ef726842ec8"
SRC_URI[sha256sum] = "eea49436309f378cb1dac7572c7a5d70ea02ea258fcfc10b6310ea4837a042de"
S = "${WORKDIR}/pilz_industrial_motion-release-release-melodic-pilz_extensions-0.4.5-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('pilz-industrial-motion', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('pilz-industrial-motion', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pilz-industrial-motion/pilz-industrial-motion_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pilz-industrial-motion/pilz-industrial-motion-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pilz-industrial-motion/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pilz-industrial-motion/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
