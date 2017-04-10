## monkeyrunner API三个模块

### MonkeyRunner 

  - 这个类提供了用于连接monkeyrunner和设备或模拟器的方法，它还提供了用于创建用户界面显示提供了方法。    

### MonkeyDevice
  
  - 代表一个设备或模拟器。这个类为安装和卸载包、开启Activity、发送按键和触摸事件、运行测试包等提供了方法。
    
### MonkeyImage
  
  - 这个类提供了捕捉屏幕的方法。这个类为截图、将位图转换成各种格式、对比两个MonkeyImage对象、将image保存到文件等提供了方法。

## 导入需要的模块

  - 给导入的模块起别名，方便使用：

```
from com.android.monkeyrunner import MonkeyRunner as mr
from com.android.monkeyrunner import MonkeyDevice as md
from com.android.monkeyrunner import MonkeyImage as mi
```
  
  - 使用时

```
device=mr.waitForConnection() 
```

## waitForConnection(参数1，参数2)

  - 等待连接到设备，没有报错代表连接成功。
  
  - 参数可写可不写
  
    - 参数1：超时时间，单位秒，浮点数。默认是无限期地等待。
    
    - 参数2：串deviceid，指定的设备名称。默认为当前设备（手机优先，比如手机通过USB线连接到PC、其次为模拟器）。

  - 示例：

```
默认连接：
      device=mr.waitForConnection()
参数连接：
      device = mr.waitForConnection(1.0,'emulator-5554')
```

## 安装或卸载APP

### 安装

```
device.installPackage('myproject/bin/MyApplication.apk')
```

  - 参数是apk文件的相对或绝对路径
  - 安装成功返回true

### 卸载

```
device.removePackage('myproject/bin/MyApplication.apk')
```

  - 删除成功返回true。

## 启动Activity

```
device.startActivity(component="com.android.calculator2/com.android.calculator2.Calculator")
或者
device.startActivity(component="com.android.calculator2/.Calculator")
```

## 执行adb shell命令

```
device.shell("input text 123")
```

## 暂停目前正在运行的程序

```
MonkeyRunner.sleep(3)
```

## 截图并保存

```
result=device.takeSnapshot()
result.writeToFile('./result1.png','png')
```

  - MonkeyImage.writeToFile(参数1:输出文件名，也可以包括路径,参数2:目标格式)
  
  - 写成功返回true，否则返回false

## 输入字符

```
device.type('字符串')
```

## 唤醒设备屏幕

```
device.wake()
```

## 重启

```
device.reboot()
```

## 在指定位置发送触摸事件（x,y的单位为像素）

```
device.touch(x,y,TouchPressType-触摸事件类型)
```

## 发送到指定键的一个关键事件

```
device.press(参数1:键码,参数2:触摸事件类型)
```

  - 示例
    
    - 按下HOME键 device.press('KEYCODE_HOME',MonkeyDevice.DOWN_AND_UP) 
    - 按下BACK键 device.press('KEYCODE_BACK',MonkeyDevice.DOWN_AND_UP) 
    - 输入回车 device.press('KEYCODE_ENTER',MonkeyDevice.DOWN_AND_UP)

  - 参数1：键码
    
    - home键 KEYCODE_HOME 
    - back键 KEYCODE_BACK 
    - send键 KEYCODE_CALL 
    - end键 KEYCODE_ENDCALL 
    - 上导航键 KEYCODE_DPAD_UP 
    - 下导航键 KEYCODE_DPAD_DOWN 
    - 左导航 KEYCODE_DPAD_LEFT 
    - 右导航键 KEYCODE_DPAD_RIGHT  
    - ok键 KEYCODE_DPAD_CENTER 
    - 上音量键 KEYCODE_VOLUME_UP  
    - 下音量键 KEYCODE_VOLUME_DOWN 
    - power键 KEYCODE_POWER 
    - camera键 KEYCODE_CAMERA 
    - menu键 KEYCODE_MENU 
