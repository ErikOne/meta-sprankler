DESCRIPTION="Hello world with scons in Yocto"
SECTION="userspace apps"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

S = "${WORKDIR}/git"

SRC_URI = "\
git:///home/erik/git-workspace/Sprankler;protocol=file;branch=master \
"
FILES_SOLIBSDEV = ""
SRCREV = "${AUTOREV}"
PV = "0.1-git${SRCPV}"

inherit scons

EXTRA_OESCONS = "-j 1 --yocto --site-dir=site_scons ${S}/do/rpi2/bin/Sprankler"

do_install() {
	install -d ${D}${bindir}
    install -d ${D}${libdir}
	install -m 644 ${S}/do/rpi2/third-party/lib/libzlog.so ${D}${libdir}
	install -m 755 ${S}/do/rpi2/bin/Sprankler ${D}${bindir}
}

FILES_${PN} += " \
	${libdir} \
    ${bindir} \
	${libdir}/libzlog.so \
	${bindir}/Sprankler \
"
