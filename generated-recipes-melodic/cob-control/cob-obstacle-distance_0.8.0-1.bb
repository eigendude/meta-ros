# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The cob_obstacle_distance package"
AUTHOR = "Felix Messmer <felixmessmer@gmail.com>"
ROS_AUTHOR = "Marco Bezzon <fxm-mb@ipa.fhg.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_control"
ROS_BPN = "cob_obstacle_distance"

ROS_BUILD_DEPENDS = " \
    assimp \
    boost \
    cmake-modules \
    cob-control-msgs \
    cob-srvs \
    dynamic-reconfigure \
    eigen-conversions \
    fcl \
    geometry-msgs \
    kdl-conversions \
    kdl-parser \
    libeigen \
    moveit-msgs \
    orocos-kdl \
    pkgconfig \
    roscpp \
    roslib \
    roslint \
    sensor-msgs \
    shape-msgs \
    std-msgs \
    tf \
    tf-conversions \
    urdf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    assimp \
    boost \
    cmake-modules \
    cob-control-msgs \
    cob-srvs \
    dynamic-reconfigure \
    eigen-conversions \
    fcl \
    geometry-msgs \
    kdl-conversions \
    kdl-parser \
    libeigen \
    moveit-msgs \
    orocos-kdl \
    pkgconfig \
    roscpp \
    roslib \
    roslint \
    sensor-msgs \
    shape-msgs \
    std-msgs \
    tf \
    tf-conversions \
    urdf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    assimp \
    boost \
    cmake-modules \
    cob-control-msgs \
    cob-srvs \
    dynamic-reconfigure \
    eigen-conversions \
    fcl \
    geometry-msgs \
    interactive-markers \
    joint-state-publisher \
    kdl-conversions \
    kdl-parser \
    libeigen \
    moveit-msgs \
    orocos-kdl \
    pkgconfig \
    robot-state-publisher \
    roscpp \
    roslib \
    roslint \
    rospy \
    rviz \
    sensor-msgs \
    shape-msgs \
    std-msgs \
    tf \
    tf-conversions \
    urdf \
    visualization-msgs \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ipa320/cob_control-release/archive/release/melodic/cob_obstacle_distance/0.8.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "278207eb5230506237bca19f3123605f"
SRC_URI[sha256sum] = "a1ea55d680727a6e39047ec20c9e86fc76591d25f36014a93a70bd1405ba7f6d"
S = "${WORKDIR}/cob_control-release-release-melodic-cob_obstacle_distance-0.8.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('cob-control', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('cob-control', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-control/cob-control_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-control/cob-control-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-control/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-control/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
