# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "ROS package for Multiple objects detection, tracking and classification from LIDAR scans/point-clouds"
AUTHOR = "Praveen Palanisamy <praveen.palanisamy@outlook.com>"
ROS_AUTHOR = "Praveen Palanisamy <praveen.palanisamy@outlook.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "multi_object_tracking_lidar"
ROS_BPN = "multi_object_tracking_lidar"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    pcl \
    pcl-ros \
    roscpp \
    sensor-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    pcl \
    pcl-ros \
    roscpp \
    sensor-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    pcl \
    pcl-ros \
    roscpp \
    sensor-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/praveen-palanisamy/multi_object_tracking_lidar-release/archive/release/melodic/multi_object_tracking_lidar/1.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/multi_object_tracking_lidar"
SRC_URI = "git://github.com/praveen-palanisamy/multi_object_tracking_lidar-release;${ROS_BRANCH};protocol=https"
SRCREV = "fc1822f7da52dc0c40947bb7e860238ca2011d51"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('multi-object-tracking-lidar', d)}"
ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
