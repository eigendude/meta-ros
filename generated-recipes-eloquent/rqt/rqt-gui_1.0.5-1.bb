# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "rqt_gui provides the main to start an instance of the ROS integrated graphical user interface provided by qt_gui."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
ROS_AUTHOR = "Dirk Thomas"
HOMEPAGE = "http://ros.org/wiki/rqt_gui"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rqt"
ROS_BPN = "rqt_gui"

ROS_BUILD_DEPENDS = " \
    qt-gui \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-python \
    python-qt-binding \
    python3-catkin-pkg \
    qt-gui \
    rclpy \
"

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

SRC_URI = "https://github.com/ros2-gbp/rqt-release/archive/release/eloquent/rqt_gui/1.0.5-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d16eaa0b1b8e8f1fd90c791104e041b9"
SRC_URI[sha256sum] = "73d7e0f20346b227fb53644b2869c461ddaa6050040cbe94b9c392d2060a4e12"
S = "${WORKDIR}/rqt-release-release-eloquent-rqt_gui-1.0.5-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rqt', d)}"
ROS_BUILD_TYPE = "ament_python"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rqt', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt/rqt_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt/rqt-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rqt/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
