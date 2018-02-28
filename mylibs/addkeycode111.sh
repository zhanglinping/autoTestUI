#!/bin/bash
localpwd=`pwd`
for testcase in `ls -d */|sed 's|[/]||g'`
do
  cd $testcase
  sed -i "/otoTest.mydevice.pressEnter();/a\               otoTest.mydevice.pressKeyCode(111);" src/com/autoTestUI/*  
  cd $localpwd
done
