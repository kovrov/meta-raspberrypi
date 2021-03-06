require ${BPN}.inc

SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/mesa-${PV}.tar.gz"

SRC_URI[md5sum] = "a4ab6a78515ef20152aa35cb2383882f"
SRC_URI[sha256sum] = "3406876aac67546d0c3e2cb97da330b62644c313e7992b95618662e13c54296a"

S = "${WORKDIR}/mesa-${PV}"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    sed -i -e 's/^#if defined(MESA_EGL_NO_X11_HEADERS)/#if ${@bb.utils.contains('DISTRO_FEATURES', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
}

# Enabling gallium-llvm creates a dependency on llvm.
# meta-openembedded provides that.

PACKAGECONFIG_append = " gallium"
PACKAGECONFIG_append = " gallium-egl"
PACKAGECONFIG_append = " gallium-gbm"
PACKAGECONFIG_append = " gallium-llvm"

DRIDRIVERSTIZEN = "swrast"
PACKAGECONFIG[dri] = "--enable-dri --with-dri-drivers=${DRIDRIVERSTIZEN}, --disable-dri, dri2proto libdrm"

GALLIUMDRIVERSTIZEN = "swrast"
GALLIUMDRIVERSTIZEN_append_raspberrypi2 = ",vc4"

GALLIUMDRIVERSTIZEN_LLVM33 = ""
GALLIUMDRIVERSTIZEN_LLVM33_ENABLED = "${@base_version_less_or_equal('MESA_LLVM_RELEASE', '3.2', False, len('${GALLIUMDRIVERSTIZEN_LLVM33}') > 0, d)}"
GALLIUMDRIVERSTIZEN_LLVM = "svga,"

# Those packages actually don't exist on mesa 10.6
ALLOW_EMPTY_libgbm-gallium = "1"
ALLOW_EMPTY_libegl-gallium = "1"
ALLOW_EMPTY_mesa-driver-pipe-swrast = "1"
ALLOW_EMPTY_mesa-driver-pipe-vmwgfx = "1"

PACKAGES =+ "mesa-driver-pipe-swrast mesa-driver-pipe-vmwgfx"
