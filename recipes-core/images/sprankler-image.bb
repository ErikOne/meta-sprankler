# Base this image on rpi-hwup-image

require recipes-core/images/core-image-minimal.bb

IMAGE_FEATURES += "ssh-server-dropbear"
IMAGE_INSTALL += "sprankler"
IMAGE_INSTALL += "ntpdate"

IMAGE_ROOTFS_SIZE = "10000"
