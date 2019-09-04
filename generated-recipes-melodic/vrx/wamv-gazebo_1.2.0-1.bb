# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Provides templates and examples for integrating the WAM-V model into gazebo with dynamics, sensors, etc."
AUTHOR = "Carlos Aguero <caguero@osrfoundation.org>"
ROS_AUTHOR = "Brian Bingham <briansbingham@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/wamv_gazebo"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "vrx"
ROS_BPN = "wamv_gazebo"

ROS_BUILD_DEPENDS = " \
    gazebo-plugins \
    hector-gazebo-plugins \
    robot-localization \
    usv-gazebo-plugins \
    velodyne-gazebo-plugins \
    wamv-description \
    xacro \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    gazebo-plugins \
    hector-gazebo-plugins \
    robot-localization \
    usv-gazebo-plugins \
    velodyne-gazebo-plugins \
    wamv-description \
    xacro \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gazebo-plugins \
    hector-gazebo-plugins \
    robot-localization \
    usv-gazebo-plugins \
    velodyne-gazebo-plugins \
    wamv-description \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/vrx-release/archive/release/melodic/wamv_gazebo/1.2.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cff44d81cad9f8cfed694c323c4fe1b6"
SRC_URI[sha256sum] = "1dea1c29c9680ba154f8c76dddb84fa18d549e7642b317331a271c9bcdac6890"
S = "${WORKDIR}/vrx-release-release-melodic-wamv_gazebo-1.2.0-1"

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
