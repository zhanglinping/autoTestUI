#!/bin/bash
localpwd=`pwd`
for testcase in `ls -d */|sed 's|[/]||g'`
do
  cd $testcase
  sed -i "/otoTest.mydevice.pressKeyCode(111);/d" src/com/autoTestUI/*  
  cd $localpwd
done
