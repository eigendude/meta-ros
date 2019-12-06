# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_crystal
inherit ros_superflore_generated

DESCRIPTION = "Small lib to transform sensor_msgs with tf. Most notably, PointCloud2"
AUTHOR = "Vincent Rabaud <vincent.rabaud@gmail.com>"
ROS_AUTHOR = "Vincent Rabaud"
HOMEPAGE = "http://www.ros.org/wiki/tf2_ros"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geometry2"
ROS_BPN = "tf2_sensor_msgs"

ROS_BUILD_DEPENDS = " \
    libeigen \
    sensor-msgs \
    tf2 \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
    libeigen \
    sensor-msgs \
    tf2 \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libeigen \
    sensor-msgs \
    tf2 \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/geometry2-release/archive/release/crystal/tf2_sensor_msgs/0.10.1-0.tar.gz
ROS_BRANCH ?= "branch=release/crystal/tf2_sensor_msgs"
SRC_URI = "git://github.com/ros2-gbp/geometry2-release;${ROS_BRANCH};protocol=https"
SRCREV = "fe4a52348ce0222b2b0b26972857e58d711c41b4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
