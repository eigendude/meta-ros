# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "ETS2/ATS sample client"
AUTHOR = "Bruno Demartino <demartinoba@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ets_ros2"
ROS_BPN = "ets_cpp_client"

ROS_BUILD_DEPENDS = " \
    ets-msgs \
    rclcpp \
    rcutils \
    rmw \
    rmw-implementation-cmake \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ets-msgs \
    launch-ros \
    rclcpp \
    rcutils \
    rmw \
    rosidl-default-runtime \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/brunodmt/ets_ros2-release/archive/release/crystal/ets_cpp_client/0.1.2-2.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3dee3b6cc10bdf60084eb7cebbdbae3a"
SRC_URI[sha256sum] = "fd8f72849064578c712fd7d106067af72c38aadfeb89fea2f19e90244df93b44"
S = "${WORKDIR}/ets_ros2-release-release-crystal-ets_cpp_client-0.1.2-2"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ets-ros2', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ets-ros2', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ets-ros2/ets-ros2_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ets-ros2/ets-ros2-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ets-ros2/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ets-ros2/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
