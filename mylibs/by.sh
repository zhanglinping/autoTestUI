#!/bin/bash

rm -rf out/target/product/x86_64/system*
repo sync
while [ $? -ne 0 ]
do
   repo sync
done
source build/envsetup.sh
lunch 12
m -j32 oto_img
m -j32 update_zip
