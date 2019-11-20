# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "libuvc_ros metapackage"
AUTHOR = "Ken Tossell <ken@tossell.net>"
HOMEPAGE = "http://ros.org/wiki/libuvc_ros"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "libuvc_ros"
ROS_BPN = "libuvc_ros"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    libuvc-camera \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libuvc-camera \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-drivers-gbp/libuvc_ros-release/archive/release/melodic/libuvc_ros/0.0.10-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/libuvc_ros"
SRC_URI = "git://github.com/ros-drivers-gbp/libuvc_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "578da9b1d1712839a96982faadfa57c7b13d43a2"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('libuvc-ros', d)}"
ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
