# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Gazebo plugins for simulating Unmanned Surface Vehicles     Originaly copied from https://github.com/bsb808/usv_gazebo_plugins"
AUTHOR = "Carlos Aguero <caguero@osrfoundation.org>"
ROS_AUTHOR = "Brian Bingham <briansbingham@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/usv_gazebo_plugins"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "vrx"
ROS_BPN = "usv_gazebo_plugins"

ROS_BUILD_DEPENDS = " \
    gazebo-ros \
    gazebo-rosdev \
    libeigen \
    roscpp \
    std-msgs \
    wave-gazebo-plugins \
    xacro \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    gazebo-ros \
    gazebo-rosdev \
    libeigen \
    roscpp \
    std-msgs \
    wave-gazebo-plugins \
    xacro \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gazebo-ros \
    gazebo-rosdev \
    libeigen \
    message-runtime \
    roscpp \
    std-msgs \
    wave-gazebo-plugins \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/vrx-release/archive/release/melodic/usv_gazebo_plugins/1.2.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "23a24e0b1227d90120d8c6b56a514eeb"
SRC_URI[sha256sum] = "2b86e504ca9b0db315abdff6f34c78552357979d5dae7e1f6b967dea5e10c1e3"
S = "${WORKDIR}/vrx-release-release-melodic-usv_gazebo_plugins-1.2.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('vrx', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('vrx', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/vrx/vrx_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/vrx/vrx-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/vrx/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/vrx/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
