# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Twist (speed and angular rate) controller for brake/throttle/steering"
AUTHOR = "Micho Radovnikovich <mradovnikovich@dataspeedinc.com>"
ROS_AUTHOR = "Micho Radovnikovich <mradovnikovich@dataspeedinc.com>"
HOMEPAGE = "http://dataspeedinc.com"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "dbw_mkz_ros"
ROS_BPN = "dbw_mkz_twist_controller"

ROS_BUILD_DEPENDS = " \
    dbw-mkz-msgs \
    dynamic-reconfigure \
    geometry-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    dbw-mkz-msgs \
    dynamic-reconfigure \
    geometry-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dbw-mkz-msgs \
    dynamic-reconfigure \
    geometry-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/DataspeedInc-release/dbw_mkz_ros-release/archive/release/melodic/dbw_mkz_twist_controller/1.2.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/dbw_mkz_twist_controller"
SRC_URI = "git://github.com/DataspeedInc-release/dbw_mkz_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "3626ac2e85dddd018a9275ea3d9feeb0fc23d949"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('dbw-mkz-ros', d)}"
ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
