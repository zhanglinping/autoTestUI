#!/bin/bash

rm -rf out/target/product/x86_64/system*
repo sync
while [ $? -ne 0 ]
do
   repo sync
done

cd /root/zxz/usermultiwin/device/generic/gnupg
git branch
git remote -v
git fetch x86
git branch -a
git checkout remotes/x86/stable
cd /root/zxz/usermultiwin

source build/envsetup.sh
lunch 12
m -j32 oto_img
m -j32 update_zip
