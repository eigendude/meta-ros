# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "The object_analytics_node package"
AUTHOR = "Chris Ye <chris.ye@intel.com>"
ROS_AUTHOR = "Peter Han <peter.han@intel.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=a530e7e8bd0b9c8e6d4e5d32904af192"

ROS_CN = "ros2_object_analytics"
ROS_BPN = "object_analytics_node"

ROS_BUILD_DEPENDS = " \
    class-loader \
    cv-bridge \
    geometry-msgs \
    lz4 \
    message-filters \
    object-analytics-msgs \
    object-msgs \
    pcl \
    pcl-conversions \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-python \
    class-loader \
    cv-bridge \
    geometry-msgs \
    lz4 \
    message-filters \
    object-analytics-msgs \
    object-msgs \
    pcl \
    pcl-conversions \
    rclcpp \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ros2_object_analytics-release/archive/release/dashing/object_analytics_node/0.5.4-2.tar.gz
ROS_BRANCH ?= "branch=release/dashing/object_analytics_node"
SRC_URI = "git://github.com/ros2-gbp/ros2_object_analytics-release;${ROS_BRANCH};protocol=https"
SRCREV = "d51f22222d4ab96722b38c95d7860014762ad187"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ros2-object-analytics', d)}"
ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
