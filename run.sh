#!/bin/bash

adb push wallpaper.jpg /sdcard/Pictures
android create uitest-project -n launcher -t 1 -p .
ant build
adb push bin/launcher.jar /data/local/tmp
adb shell uiautomator runtest launcher.jar -c com.autoTestUI.launcher

