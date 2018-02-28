#!/bin/bash
localpwd=`pwd`
for testcase in `ls -d */|sed 's|[/]||g'`
do
  cd $localpwd
  cd $testcase
  touch packagename
  name=`cat $testcase.sh | grep uninstall`
  echo ${name:46} > packagename
  cat packagename
  rm ${testcase}Make.sh
  rm $testcase.sh
  rm -rf lkp_test
  ln -s ../common/commonMake.sh ${testcase}Make.sh
  ln -s ../common/comtest.sh $testcase.sh
  ln -s ../common/lkp_test .
  cd $localpwd
done
