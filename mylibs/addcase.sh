#!/bin/bash

oldname=acrobat
casename=quickpicker
##xuetang

cp -r benchmark_mirror/$oldname benchmark_mirror/$casename
mv benchmark_mirror/$casename/$oldname benchmark_mirror/$casename/$casename
mv benchmark_mirror/$casename/$oldname"_benchmark.expt" benchmark_mirror/$casename/$casename"_benchmark.expt"
sed -i "s/$oldname/$casename/g" `grep $oldname -rl benchmark_mirror/$casename/`
rm benchmark_mirror/$casename/adobe_acrobat.apk
mv /home/zhanglp/workspace/$casename/$casename".apk" benchmark_mirror/$casename/

cd /home/zhanglp/aautoTest/oto_external_lkp/benchmark_mirror
tar -zcvf $casename".tar.gz" $casename/
chmod 777 $casename".tar.gz"
cd /home/zhanglp/aautoTest/oto_external_lkp/

cp joblist/$oldname.sh joblist/$casename.sh
sed -i "s/$oldname/$casename/g" `grep $oldname -rl joblist/$casename.sh`

cp lkp-tests-master/tests/$oldname lkp-tests-master/tests/$casename
sed -i "s/$oldname/$casename/g" `grep $oldname -rl lkp-tests-master/tests/$casename`

cp lkp-tests-master/jobs/$oldname.yaml lkp-tests-master/jobs/$casename.yaml
sed -i "s/$oldname/$casename/g" `grep $oldname -rl lkp-tests-master/jobs/$casename.yaml`

cp lkp-tests-master/pack/$oldname lkp-tests-master/pack/$casename
cp lkp-tests-master/pack/$oldname"_pack.expt" lkp-tests-master/pack/$casename"_pack.expt"
sed -i "s/$oldname/$casename/g" `grep $oldname -rl lkp-tests-master/pack/$casename`
sed -i "s/adobe_acrobat/$casename/g" `grep adobe_acrobat -rl lkp-tests-master/pack/$casename"_pack.expt"`
sed -i "s/$oldname/$casename/g" `grep $oldname -rl lkp-tests-master/pack/$casename"_pack.expt"`

cp lkp-tests-master/stats/$oldname lkp-tests-master/stats/$casename

mkdir testcase/$casename
cp -r testcase/$oldname/lkp_test/ testcase/$casename/
cp testcase/$oldname/commitId.txt testcase/$casename/
cp testcase/$oldname/fortest.sh testcase/$casename/
cp testcase/$oldname/run_withlog.sh testcase/$casename/
cp testcase/$oldname/$oldname.sh testcase/$casename/$casename.sh
cp testcase/$oldname/$oldname"Make.sh" testcase/$casename/$casename"Make.sh"
sed -i "s/$oldname/$casename/g" `grep $oldname -rl testcase/$casename/`

cp -r /home/zhanglp/workspace/$casename/* testcase/$casename/
cp /home/zhanglp/workspace/$casename/.project testcase/$casename/
cp /home/zhanglp/workspace/$casename/.classpath testcase/$casename/
