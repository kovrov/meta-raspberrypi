RPIFW_SRCREV ?= "b06b317afb60547b436cd30e056b54cec7ae3b8e"
RPIFW_DATE ?= "20151004"
RPIFW_SRC_URI ?= "git://github.com/raspberrypi/firmware.git;protocol=git;branch=master"
RPIFW_S ?= "${WORKDIR}/git"

SRC_URI = "${RPIFW_SRC_URI}"
SRCREV = "${RPIFW_SRCREV}"
PV = "${RPIFW_DATE}"
