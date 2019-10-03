# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package provides a set of typedef's that allow   using Eigen datatypes in STL containers"
AUTHOR = "Chris Lalancette <clalancette@osrfoundation.org>"
ROS_AUTHOR = "Ioan Sucan <isucan@willowgarage.com>"
HOMEPAGE = "http://eigen.tuxfamily.org/dox/TopicUnalignedArrayAssert.html"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "eigen_stl_containers"
ROS_BPN = "eigen_stl_containers"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    libeigen \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    libeigen \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libeigen \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/eigen_stl_containers-release/archive/release/melodic/eigen_stl_containers/0.1.8-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a737690c3c8142804bc2ce7a9c841d5e"
SRC_URI[sha256sum] = "e10632b9c182ffc09170b5fc80bf0a0f3cb8ab1091c01b44953042ba71ad5843"
S = "${WORKDIR}/eigen_stl_containers-release-release-melodic-eigen_stl_containers-0.1.8-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('eigen-stl-containers', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('eigen-stl-containers', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/eigen-stl-containers/eigen-stl-containers_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/eigen-stl-containers/eigen-stl-containers-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/eigen-stl-containers/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/eigen-stl-containers/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
