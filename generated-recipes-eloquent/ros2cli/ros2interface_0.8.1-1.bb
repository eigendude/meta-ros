# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The interface command for ROS 2 command line tools"
AUTHOR = "Jacob Perron <jacob@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ros2cli"
ROS_BPN = "ros2interface"

ROS_BUILD_DEPENDS = " \
    ros2cli \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    ros2cli \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-python \
    ros2cli \
    rosidl-runtime-py \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    ament-xmllint \
    python3-pytest \
    std-msgs \
    std-srvs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/ros2cli-release/archive/release/eloquent/ros2interface/0.8.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e9e337285d5c6a4820cc0fee0d2fcbbf"
SRC_URI[sha256sum] = "214957c464617d4c856c92aa48c5f9697599a4df6c703baf0e9f4f62a762f7a4"
S = "${WORKDIR}/ros2cli-release-release-eloquent-ros2interface-0.8.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ros2cli', d)}"
ROS_BUILD_TYPE = "ament_python"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ros2cli', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros2cli/ros2cli_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros2cli/ros2cli-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros2cli/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ros2cli/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
