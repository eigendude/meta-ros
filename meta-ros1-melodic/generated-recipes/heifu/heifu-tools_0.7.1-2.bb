# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Heifu Tools"
AUTHOR = "João Pedro Carvalho <joao.m.carvalho@pdmfc.com>"
ROS_AUTHOR = "João Pedro Carvalho <joao.m.carvalho@pdmfc.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "TODO"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=2feaf30a620f46f06a4b016624acf46f"

ROS_CN = "heifu"
ROS_BPN = "heifu_tools"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    image-view \
    joy \
    joy-teleop \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    image-view \
    joy \
    joy-teleop \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/amferreiraBEV/heifu-release/archive/release/melodic/heifu_tools/0.7.1-2.tar.gz
ROS_BRANCH ?= "branch=release/melodic/heifu_tools"
SRC_URI = "git://github.com/amferreiraBEV/heifu-release;${ROS_BRANCH};protocol=https"
SRCREV = "878d8fb8c59d1c3a9746d07f11fa7d4175cf73b9"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}