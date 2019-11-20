# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Transports audio from a source to a destination. Audio sources can come       from a microphone or file. The destination can play the audio or save it       to an mp3 file."
AUTHOR = "Austin Hendrix <namniart@gmail.com>"
ROS_AUTHOR = "Nate Koenig"
HOMEPAGE = "http://ros.org/wiki/audio_capture"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=a3ae2ba3f0f44e61270955e8cd98afcf"

ROS_CN = "audio_common"
ROS_BPN = "audio_capture"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libgstreamer-plugins-base1.0-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libgstreamer1.0-dev} \
    audio-common-msgs \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-base} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-good} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-ugly} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0} \
    audio-common-msgs \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-base} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-good} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-ugly} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0} \
    audio-common-msgs \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/audio_common-release/archive/release/melodic/audio_capture/0.3.3-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/audio_capture"
SRC_URI = "git://github.com/ros-gbp/audio_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "1c387f50c07af770b83055df5fde7a3f566838c2"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('audio-common', d)}"
ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
