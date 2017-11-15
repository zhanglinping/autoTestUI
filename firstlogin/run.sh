#!/bin/bash

name=firstlogin

android create uitest-project -n $name -t 1 -p .
ant build
adb push bin/$name.jar /data/local/tmp
adb shell uiautomator runtest $name.jar -c com.$name.$name

