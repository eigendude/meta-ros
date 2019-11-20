# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "rosping is the tool to send ICMP ECHO_REQUEST to network hosts where roscore is running, and send back to you as rostopic message. <br/>     For echoing ROS node, use <a href="http://wiki.ros.org/rosnode">rosnode</a>."
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "http://ros.org/wiki/rosping"
SECTION = "devel"
LICENSE = "Boost-1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d98785270c85a483b5697dfd09b5f41a"

ROS_CN = "jsk_3rdparty"
ROS_BPN = "rosping"

ROS_BUILD_DEPENDS = " \
    mk \
    rosboost-cfg \
    rosbuild \
    roscpp \
    rostest \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roscpp \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/jsk_3rdparty-release/archive/release/melodic/rosping/2.1.13-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rosping"
SRC_URI = "git://github.com/tork-a/jsk_3rdparty-release;${ROS_BRANCH};protocol=https"
SRCREV = "709017758c293c2e4cd5ccfbee5d795f23a04cfb"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('jsk-3rdparty', d)}"
ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
