DESCRIPTION = "Components of MoveIt connecting to perception"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "moveit-core tf-conversions image-transport cv-bridge"

require moveit.inc

ROS_BPN = "moveit_ros/perception"

SRC_URI += "file://0001-moveit_ros-perception-do-not-use-SYSTEM.patch;striplevel=3"

EXTRA_OECMAKE_append = " -DWITH_OPENGL=OFF"
