#!/bin/bash -xu
ip_android=192.168.0.159
adbPort=5555
testfold=testcases
date=`date +%Y%m%d`

mkdir $date
adb kill-server
adb connect $ip_android

./buildGuiTestcase.sh
cd $testfold
for testcase in `ls -d */|sed 's|[/]||g'`
do  
    $testcase/$testcase".sh" $ip_android $adbPort $testcase"_result"
    mv $testcase/$testcase"_result" ../$date
done
