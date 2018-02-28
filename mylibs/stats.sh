#!/bin/bash
localpwd=`pwd`
for testcase in `ls -d */|sed 's|[/]||g'`
do
  cd $localpwd
  cd ../lkp-tests-master/stats/
  sed -i "s/0/-1/g" $testcase
  cd $localpwd
done
