# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "octomap_server loads a 3D map (as Octree-based OctoMap) and distributes it to other nodes in a compact binary format. It also allows to incrementally build 3D OctoMaps, and provides map saving in the node octomap_saver."
AUTHOR = "Wolfgang Merkt <w.merkt+oss@gmail.com>"
ROS_AUTHOR = "Armin Hornung"
HOMEPAGE = "http://www.ros.org/wiki/octomap_server"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "octomap_mapping"
ROS_BPN = "octomap_server"

ROS_BUILD_DEPENDS = " \
    dynamic-reconfigure \
    nav-msgs \
    nodelet \
    octomap \
    octomap-msgs \
    octomap-ros \
    pcl \
    pcl-conversions \
    pcl-ros \
    roscpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    dynamic-reconfigure \
    nav-msgs \
    nodelet \
    octomap \
    octomap-msgs \
    octomap-ros \
    pcl \
    pcl-conversions \
    pcl-ros \
    roscpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dynamic-reconfigure \
    nav-msgs \
    nodelet \
    octomap \
    octomap-msgs \
    octomap-ros \
    pcl \
    pcl-conversions \
    pcl-ros \
    roscpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/octomap_mapping-release/archive/release/melodic/octomap_server/0.6.3-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/octomap_server"
SRC_URI = "git://github.com/ros-gbp/octomap_mapping-release;${ROS_BRANCH};protocol=https"
SRCREV = "bdba0f537aa86df967d1387c5ab473d393110ffc"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('octomap-mapping', d)}"
ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
