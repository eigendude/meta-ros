# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package contains a single node that monitors the drift of the IMU gyroscopes. The results are published to the '/diagnostics' topic and are aggregated in the PR2 dashboard."
AUTHOR = "Dave Feil-Seifer <dave@cse.unr.edu>"
ROS_AUTHOR = "Wim Meeussen"
HOMEPAGE = "http://ros.org/wiki/imu_monitor"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_robot"
ROS_BPN = "imu_monitor"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    diagnostic-msgs \
    pr2-mechanism-controllers \
    python-orocos-kdl \
    rospy \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diagnostic-msgs \
    pr2-mechanism-controllers \
    python-orocos-kdl \
    rospy \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_robot-release/archive/release/melodic/imu_monitor/1.6.31-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/imu_monitor"
SRC_URI = "git://github.com/pr2-gbp/pr2_robot-release;${ROS_BRANCH};protocol=https"
SRCREV = "ed22c1064b4695e634d3faeb5c40ae3e372dc4da"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}