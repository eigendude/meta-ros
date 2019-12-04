# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_crystal
inherit ros_superflore_generated

DESCRIPTION = "AprilTag2 detection node"
AUTHOR = " <Rauch.Christian@gmx.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "apriltag2_node"
ROS_BPN = "apriltag2_node"

ROS_BUILD_DEPENDS = " \
    apriltag \
    apriltag-msgs \
    class-loader \
    libeigen \
    rclcpp \
    sensor-msgs \
    tf2-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    apriltag \
    apriltag-msgs \
    class-loader \
    rclcpp \
    sensor-msgs \
    tf2-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    apriltag \
    apriltag-msgs \
    class-loader \
    rclcpp \
    sensor-msgs \
    tf2-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/christianrauch/apriltag2_node-release/archive/release/crystal/apriltag2_node/1.0.1-0.tar.gz
ROS_BRANCH ?= "branch=release/crystal/apriltag2_node"
SRC_URI = "git://github.com/christianrauch/apriltag2_node-release;${ROS_BRANCH};protocol=https"
SRCREV = "06b095d4af62941320544024510eee3a07bb522e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}