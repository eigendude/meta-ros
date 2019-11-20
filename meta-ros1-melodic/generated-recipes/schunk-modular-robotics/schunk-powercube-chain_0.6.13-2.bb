# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This packages provides a configurable driver of a chain   of Schunk powercubes. The powercube chain is configured   through parameters. Most users will not directly interact   with this package but with the corresponding launch files   in other packages, e.g. schunk_bringup, cob_bringup, ..."
AUTHOR = "Florian Weisshardt <fmw@ipa.fhg.de>"
ROS_AUTHOR = "Florian Weisshardt <fmw@ipa.fhg.de>"
HOMEPAGE = "http://ros.org/wiki/schunk_powercube_chain"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "schunk_modular_robotics"
ROS_BPN = "schunk_powercube_chain"

ROS_BUILD_DEPENDS = " \
    cob-srvs \
    control-msgs \
    diagnostic-msgs \
    libntcan \
    libpcan \
    roscpp \
    schunk-libm5api \
    sensor-msgs \
    std-msgs \
    std-srvs \
    trajectory-msgs \
    urdf \
    virtual/kernel \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cob-srvs \
    control-msgs \
    diagnostic-msgs \
    libntcan \
    libpcan \
    roscpp \
    schunk-libm5api \
    sensor-msgs \
    std-msgs \
    std-srvs \
    trajectory-msgs \
    urdf \
    virtual/kernel \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cob-srvs \
    control-msgs \
    diagnostic-msgs \
    libntcan \
    libpcan \
    roscpp \
    schunk-libm5api \
    sensor-msgs \
    std-msgs \
    std-srvs \
    trajectory-msgs \
    urdf \
    virtual/kernel \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ipa320/schunk_modular_robotics-release/archive/release/melodic/schunk_powercube_chain/0.6.13-2.tar.gz
ROS_BRANCH ?= "branch=release/melodic/schunk_powercube_chain"
SRC_URI = "git://github.com/ipa320/schunk_modular_robotics-release;${ROS_BRANCH};protocol=https"
SRCREV = "5bf7d85a123f301e421888f6d4a602a31d5f5ee8"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('schunk-modular-robotics', d)}"
ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
