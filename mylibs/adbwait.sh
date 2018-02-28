#!/bin/bash

androidIP=$1
i=0
while (($i<10))
do
    sleep 1
    let "i++"
    echo $i
    adb connect $androidIP
    device=`adb devices | grep "\<device\>" | awk '{print $1}'`
if [ "$device" != "" ];then
    break
fi
done
