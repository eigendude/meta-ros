# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "<p>       Kobuki message and service types: custom messages and services for Kobuki packages.     </p>"
AUTHOR = "Daniel Stonier <stonier@yujinrobot.com>"
ROS_AUTHOR = "Daniel Stonier <stonier@yujinrobot.com>"
HOMEPAGE = "http://ros.org/wiki/kobuki_msgs"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "kobuki_msgs"
ROS_BPN = "kobuki_msgs"

ROS_BUILD_DEPENDS = " \
    actionlib-msgs \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib-msgs \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib-msgs \
    message-runtime \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/yujinrobot-release/kobuki_msgs-release/archive/release/melodic/kobuki_msgs/0.7.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/kobuki_msgs"
SRC_URI = "git://github.com/yujinrobot-release/kobuki_msgs-release;${ROS_BRANCH};protocol=https"
SRCREV = "4f85726fca43c6f799b8b91e7fe717932c2e402b"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('kobuki-msgs', d)}"
ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
