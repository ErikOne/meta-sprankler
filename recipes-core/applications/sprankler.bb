DESCRIPTION="Hello world with scons in Yocto"
SECTION="userspace apps"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


S = "${WORKDIR}/git"

SRC_URI = "\
git:///home/erik/git-workspace/Sprankler;protocol=file;branch=master \
"

SRCREV = "${AUTOREV}"
PV = "0.1-git${SRCPV}"

inherit scons

EXTRA_OESCONS = "--site-dir=site_scons ${S}/do/vanuit-yocto/bin/Sprankler"

do_install() {
	install -d ${D}/usr/bin
    install -m 755 ${S}/do/vanuit-yocto/bin/Sprankler ${D}/usr/bin
}

FILES_${PN} += " \
        /usr/bin/Sprankler \
"
