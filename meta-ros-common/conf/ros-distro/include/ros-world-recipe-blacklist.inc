# Blacklist all failing task for CI jobs to easily compare
# if "bitbake world" is getting better or worse

# LICENSE_FLAGS_WHITELIST restrictions
ROS_WORLD_SKIP_GROUPS += "world-license"

PNBLACKLIST[gstreamer1.0-plugins-bad] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[gstd] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on gstreamer1.0-plugins-bad which depends on faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[gst-shark] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on gstreamer1.0-plugins-bad which depends on faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[packagegroup-meta-multimedia] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'rdepends on gstd, gst-shark which depend on gstreamer1.0-plugins-bad which depends on faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[gstreamer1.0-vaapi] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on gstreamer1.0-plugins-bad->faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[webkitgtk] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on gstreamer1.0-plugins-bad->faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[epiphany] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on webkitgtk->gstreamer1.0-plugins-bad->faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[packagegroup-self-hosted] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on epiphany->webkitgtk->gstreamer1.0-plugins-bad->faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[clutter-gst-3.0] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on gstreamer1.0-plugins-bad->faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[packagegroup-core-clutter] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on clutter-gst-3.0->gstreamer1.0-plugins-bad->faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[omxplayer] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on libav, libomxil which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[gst-examples] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on gstreamer1.0-plugins-bad which depends on faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[packagegroup-core-x11-sato] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on gst-examples which depends on gstreamer1.0-plugins-bad which depends on faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[packagegroup-core-tools-testapps] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['world-license', 'python2'], 'world-license: depends on gst-examples which depends on gstreamer1.0-plugins-bad which depends on faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST; python: depends on python2', '', d)}"

# Recipes failing because of svn fetcher issue
# http://lists.openembedded.org/pipermail/openembedded-devel/2020-February/205012.html
ROS_WORLD_SKIP_GROUPS += "world-svn-fetcher"
# meta-openembedded/meta-oe/recipes-support/samsung-soc-utils/s3c24xx-gpio_svn.bb:do_populate_lic
# meta-openembedded/meta-oe/recipes-support/samsung-soc-utils/s3c24xx-gpio_svn.bb:do_compile
PNBLACKLIST[s3c24xx-gpio] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-svn-fetcher', 'S does not point to correct directory with bitbake svn fetcher anymore', '', d)}"
# meta-openembedded/meta-oe/recipes-support/samsung-soc-utils/s3c64xx-gpio_svn.bb:do_populate_lic
# meta-openembedded/meta-oe/recipes-support/samsung-soc-utils/s3c64xx-gpio_svn.bb:do_compile
PNBLACKLIST[s3c64xx-gpio] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-svn-fetcher', 'S does not point to correct directory with bitbake svn fetcher anymore', '', d)}"
# meta-openembedded/meta-oe/recipes-support/wmiconfig/wmiconfig_svn.bb:do_patch
PNBLACKLIST[wmiconfig] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-svn-fetcher', 'S does not point to correct directory with bitbake svn fetcher anymore', '', d)}"
# meta-openembedded/meta-oe/recipes-support/usbpath/usbpath_svn.bb:do_patch
PNBLACKLIST[usbpath] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-svn-fetcher', 'S does not point to correct directory with bitbake svn fetcher anymore', '', d)}"

# Other issues:
ROS_WORLD_SKIP_GROUPS += "world-issues"
PNBLACKLIST[wiringpi] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Fails to fetch: git.drogon.net[0: 188.246.205.22]: errno=Connection refused', '', d)}"
PNBLACKLIST[packagegroup-rpi-test] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['world-issues', 'python2'], 'world-issues: Depends on blacklisted packages like wiringpi and recipes from meta-multimedia we do not depend on: bigbuckbunny-480p, bigbuckbunny-720p, bigbuckbunny-1080p and wireless-regdb from meta-networking; python2: Depends on blacklisted python2', '', d)}"
PNBLACKLIST[kernel-selftest] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Fails to build with linux-yocto kernel: WARNING: clang >= 6.0  with bpf support is needed with kernel 4.18+ so either install it and add it to HOSTTOOLS, or add clang-native from meta-clang to dependency and then /bin/sh: 1: llc: not found + /bin/sh: 1: clang: not found + /bin/sh: 1: llvm-readelf: not found', '', d)}"
PNBLACKLIST[vboxguestdrivers] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Fails to build with linux-yocto kernel: vboxguestdrivers/5.2.22-r0/vbox_module/vboxguest/r0drv/linux/time-r0drv-linux.c:175:5: error: implicit declaration of function ktime_get_real_ts; did you mean ktime_get_real_ns? [-Werror=implicit-function-declaration]', '', d)}"
PNBLACKLIST[renderdoc] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Depends on mesa-gl without setting correct REQUIRED_DISTRO_FEATURES to match it: mesa-gl PROVIDES virtual/libgl but was skipped: one of vulkan opengl needs to be in DISTRO_FEATURES', '', d)}"
PNBLACKLIST[remmina] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['world-issues', 'python2'], 'world-issues: Depends on spice, spice-protocol from meta-networking, fixed in dunfell: http://git.openembedded.org/meta-openembedded/commit/?id=876f4ce7639def476664834acafbf87cc227fb05; python2: Depends on blacklisted python2', '', d)}"
PNBLACKLIST[packagegroup-meta-oe] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['world-issues', 'world-svn-fetcher', 'python2'], 'world-issues: Depends on blacklisted packages like ndctl; world-svn-fetcher: Depends on blacklisted packages like s3c24xx-gpio, s3c64xx-gpio, wmiconfig, usbpath; python2: Depends on blacklisted python2', '', d)}"

PNBLACKLIST[userland] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', 'depends on libegl-mesa from mesa-gl which is not available without opengl in DISTRO_FEATURES', '', d)}"
