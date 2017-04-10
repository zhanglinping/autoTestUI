# monkeyrunner API

## 三个模块

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
result.writeToFile('takeSnapshot\\result1.png','png')
```

写文件MonkeyImage

MonkeyImage.writeToFile(参数1:输出文件名，也可以包括路径,参数2:目标格式)
写成功返回true，否则返回false


键盘上的类型指定的字符串，这相当于要求每个字符串中的字符按（键码，DOWN_AND_UP）.
字符串发送到键盘
device.type('字符串')

唤醒设备屏幕（在设备屏幕上唤醒）

device.wake()

重新引导到指定的引导程序指定的设备

device.reboot()
=========================================================

在指定位置发送触摸事件（x,y的单位为像素）

device.touch(x,y,TouchPressType-触摸事件类型)

发送到指定键的一个关键事件

device.press(参数1:键码,参数2:触摸事件类型)
参数1：见android.view.KeyEvent
参数2，如有TouchPressType()返回的类型－触摸事件类型，有三种。
1、DOWN 发送一个DOWN事件。指定DOWN事件类型发送到设备，对应的按一个键或触摸屏幕上。
2、UP 发送一个UP事件。指定UP事件类型发送到设备，对应释放一个键或从屏幕上抬起。
3、DOWN_AND_UP 发送一个DOWN事件，然后一个UP事件。对应于输入键或点击屏幕。
以上三种事件做为press()或touch()参数。原英文如下：
use this with the type argument of press() or touch() to send a down event.


为了模拟输入键，发送DOWN_AND_UP。


参数1的部分具体内容逻辑：

按下HOME键 device.press('KEYCODE_HOME',MonkeyDevice.DOWN_AND_UP) 
按下BACK键 device.press('KEYCODE_BACK',MonkeyDevice.DOWN_AND_UP) 
按下下导航键 device.press('KEYCODE_DPAD_DOWN',MonkeyDevice.DOWN_AND_UP) 
按下上导航键 device.press('KEYCODE_DPAD_UP',MonkeyDevice.DOWN_AND_UP) 
按下OK键 device.press('KEYCODE_DPAD_CENTER',MonkeyDevice.DOWN_AND_UP)


device.press('KEYCODE_ENTER',MonkeyDevice.DOWN_AND_UP)#输入回车
device.press('KEYCODE_BACK',MonkeyDevice.DOWN_AND_UP)#点击返回

home键 KEYCODE_HOME 
back键 KEYCODE_BACK 
send键 KEYCODE_CALL 
end键 KEYCODE_ENDCALL 
上导航键 KEYCODE_DPAD_UP 
下导航键 KEYCODE_DPAD_DOWN 
左导航 KEYCODE_DPAD_LEFT 
右导航键 KEYCODE_DPAD_RIGHT  
ok键 KEYCODE_DPAD_CENTER 
上音量键 KEYCODE_VOLUME_UP  
下音量键 KEYCODE_VOLUME_DOWN 
power键 KEYCODE_POWER 
camera键 KEYCODE_CAMERA 
menu键 KEYCODE_MENU 
