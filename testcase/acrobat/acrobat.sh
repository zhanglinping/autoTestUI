#!/bin/bash -x
androidIP=$1
port=$2
foldName=$3
mkdir $foldName

android create uitest-project -n acrobat -t 1 -p .
ant build
adb connect $androidIP
adb push bin/acrobat.jar /data/local/tmp
adb shell uiautomator runtest acrobat.jar -c com.autoTestUI.acrobat

python TmpTojson.py $foldName/tmpResultToJson $foldName
