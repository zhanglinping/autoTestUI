#!/bin/bash
localpwd=`pwd`
for testcase in `ls -d */|sed 's|[/]||g'`
do
  cd $localpwd
  cd ../../oto_external_lkp/benchmark_mirror/
  rm $testcase".tar.gz"
  rm $testcase/*.apk
  cp $localpwd/$testcase/*.apk $testcase/
  tar -zcvf $testcase".tar.gz" $testcase/
  chmod 777 $testcase".tar.gz"
  cd $localpwd
  cd ../../oto_external_lkp/testcase/$testcase/
  rm -rf bin src
  cd $localpwd
  cd $testcase
  cp -r bin src ../../../oto_external_lkp/testcase/$testcase/
done
