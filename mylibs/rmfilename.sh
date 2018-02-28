#!/bin/bash
localpwd=`pwd`
for testcase in `ls -d */|sed 's|[/]||g'`
do
  cd $testcase
  sed -i "s/"'\/$filename1\/'"/\//g" $testcase.sh
  cd $localpwd
done
