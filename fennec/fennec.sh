#!/bin/bash -x
androidIP=$1
port=$2
foldName=$3
mkdir $foldName

android create uitest-project -n fennec -t 1 -p .
ant build
adb connect $androidIP
adb push bin/fennec.jar /data/local/tmp
adb shell uiautomator runtest fennec.jar -c com.autoTestUI.fennec

python TmpTojson.py $foldName/tmpResultToJson $foldName
