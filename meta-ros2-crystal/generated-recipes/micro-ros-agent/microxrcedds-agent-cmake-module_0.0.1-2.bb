# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_crystal
inherit ros_superflore_generated

DESCRIPTION = "Provide CMake module to find eProsima Micro XRCE-DDS Agent"
AUTHOR = "Borja Outerelo <borjaouterelo@eprosima.com>"
ROS_AUTHOR = "Borja Outerelo"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "micro-ROS-Agent"
ROS_BPN = "microxrcedds_agent_cmake_module"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_micro-xrce-dds-agent} \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_micro-xrce-dds-agent} \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

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

# matches with: https://github.com/micro-ROS/micro-ROS-Agent-release/archive/release/crystal/microxrcedds_agent_cmake_module/0.0.1-2.tar.gz
ROS_BRANCH ?= "branch=release/crystal/microxrcedds_agent_cmake_module"
SRC_URI = "git://github.com/micro-ROS/micro-ROS-Agent-release;${ROS_BRANCH};protocol=https"
SRCREV = "4036bfecc28c396060c80bd288fc56a37cfa7c72"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
