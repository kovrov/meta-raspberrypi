LINUX_VERSION ?= "4.1.0"

SRCREV = "07009cab090ade3dd180e8a55d590b1a00072eed"
SRC_URI = "\
 git://github.com/anholt/linux.git;protocol=git;branch=vc4-kms-v3d-rpi2 \
 file://0001-ARM-bcm2709_defconfig-Enable-config-options-for-vc4-.patch \
 file://0002-ARM-dts-Fix-i2c-for-bcm2709-RPI2-B-board.patch \
 file://0003-drm-vc4-Use-the-fbdev_cma-helpers.patch \
 file://0004-drm-vc4-Allow-vblank-to-be-disabled.patch \
 file://0005-drm-vc4-Disable-KMS-operations.patch \
"

require linux-raspberrypi.inc
