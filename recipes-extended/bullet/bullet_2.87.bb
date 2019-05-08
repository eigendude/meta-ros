DESCRIPTION = "Bullet Physics SDK"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=74f06ab3011994d1b43d71ecbb42a7cf"

SRC_URI = "https://github.com/bulletphysics/bullet3/archive/${PV}.tar.gz"
SRC_URI[md5sum] = "7566fc00d925a742e6f7ec7ba2d352de"
SRC_URI[sha256sum] = "438c151c48840fe3f902ec260d9496f8beb26dba4b17769a4a53212903935f95"

SRC_URI += "file://0001-CMakeLists.txt-do-not-find-PythonLibs.patch"

S = "${WORKDIR}/bullet3-2.87"

inherit cmake pythonnative

FILES_${PN}-dev += " \
  /usr/lib/ \
  /usr/lib/cmake \
  /usr/lib/cmake/bullet \
  /usr/lib/cmake/bullet/UseBullet.cmake \
  /usr/lib/cmake/bullet/BulletConfig.cmake \
"


EXTRA_OECMAKE = "-DBUILD_PYBULLET=OFF"
