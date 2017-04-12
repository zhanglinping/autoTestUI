## GUI测试用例仓库：https://github.com/openthos/oto_Uitest

## 将GUI测试集成到LKP中（以QQ测试为例）

- 在oto_lkp/testcase/下创建名为QQ的目录

- 将QQ测试用例从oto_Uitest库中拷贝进来，删除多余文件，仅保留bin/ src/ .project和.classpath

- 使用eclipse打开工程，进行编辑，仅保留QQ.java、otoDisplayRun.java、window_lib.java

    - window_lib.java不需要修改，可直接将wechat中的复制
    
    - otoDisplayRun.java也直接复制，仅需修改SolveProblems()部分
    
    - QQ.java中，部分相同，可复制后进行操作部分的修改

## 包名获取

- aapt dump badging ×.apk

- adb shell dumpsys window w | grep name=
