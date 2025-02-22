## 1、com.android.monkeyrunner.MonkeyRunner.alert

  - 执行当前脚本弹出一个警示对话框，用户关闭对话框后脚本才结束。可以使用在脚本运行之前,判断手机设备连接。
  - 用法：MonkeyRunner.alert(string message, string title, string okTitle)
    - message：会话弹出的内容
    - title：会话标题，默认为alert
    - okTitle：会话确认按钮，默认为ok
  - 返回值：nothing

## 2、com.android.monkeyrunner.MonkeyRunner.choice

  - 显示一个对话框，让用户从一列选项中选择一个单一的选项。可以可以在脚本运行之前,选择需要运行的脚本。
  - 用法：MonkeyRunner.choice(string message, iterable choices, string title)
    - message：显示在对话框中的提示信息。
    - choices：列表数组
    - title：对话框的标题，默认为input
    - 例子：MonkeyRunner.choice('message',['choice1','choice2','choice3'],'title')
  - 返回值: 
    - 如果用户选择并点击确认按钮,返回0-数组最大值
    - 如果用户关闭了对话框,返回值为-1
 
## 3、com.android.monkeyrunner.MonkeyRunner.help

  - 打印出MonkeyRunner的帮助信息
  - 用法：MonkeyRunner.help(format)
    - format：The desired format for the output, either 'text' for plain text or 'html' for HTML markup
  - 返回值: A string containing the help text in the desired format

## 4、com.android.monkeyrunner.MonkeyRunner.input

  - 显示一个可输入对话框。用例执行之前,输入测试存放文件夹名称。
  - 用法：MonkeyRunner.input(string message, string initialValue, string title, string okTitle, string cancelTitle))
    - message：对话框显示的信息。The prompt message to display in the dialog
    - initialValue：提供给用户的初始化值，默认为空字符串
    - title：对话标题，默认为input
    - okTitle：确认按钮的文本显示.默认为"OK"
    - cancelTitle：取消按钮的文本显示.默认为"Cancel"
    - 例子：MonkeyRunner.input('message','please input','title','ok','cancel')
  - 返回值：
    - 如果用户点击确认按钮,将文本框的值返回
    - 如果用户点击取消按钮,将返回一个空的String

## 5、com.android.monkeyrunner.MonkeyRunner.sleep

  - 暂停当前运行进程指定的时间。设置延迟，等待界面跳转或者程序响应。
  - 用法：MonkeyRunner.sleep(seconds)
    - seconds：暂停时间
  - 返回值：nothing

## 6、com.android.monkeyrunner.MonkeyRunner.waitForConnection

  - 等待电脑连接到设备。
  - 用法：MonkeyRunner.waitForConnection(timeout,deviceId)
    - timeout：等待的时间，默认为无限期
    - deviceId：设备Id，可通过adb device获得，如果仅有一台设备时，可以不输入
  - 返回值: 一个表示已经连接的设备对象，A MonkeyDevice object

## 7、com.android.monkeyrunner.MonkeyImage.convertToBytes

  - 将图片转换为其他特殊的格式，将结果作为字符串返回，用这个方法将像素存取为特殊的格式，输出的字符串是一种更好的表现。
  - 用法：MonkeyImage.convertToBytes(format)
    - format：目标格式，默认值为png。
  - 返回值: 目标图片格式的字符串

## 8、com.Android.monkeyrunner.MonkeyDevice.broadcastIntent
  
  - 对设备发送一个广播信号。
  - 用法：MonkeyDevice.broadcastIntent(uri,action,data,mimetype,categories,extras,component,flags)
    - uri：信号的uri
    - action：The action for the Intent
    - data：The data URI for the Intent
    - mimetype：The mime type for the Intent
    - categories：An iterable of category names for the Intent
    - extras：A dictionary of extras to add to the Intent. Types of these extras are inferred from the python types of the values   
    - component：The component of the Intent
    - flags：An iterable of flags for the Intent.All arguments are optional. The default value for each argument is null
  - 返回值: nothing

## 9、com.android.monkeyrunner.MonkeyImage.getRawPixel

  - 在x,y位置处获取一个单个的ARGB像素，参数x，y都是基于0坐标，表示一个像素尺寸，x向右增益，y向下增益，这个方法返回一个数组。
  - 用法：MonkeyImage.getRawPixel(x,y)
     - x：x偏移
     - y：y偏移
  - 返回值: A tuple of (A, R, G, B) for the pixel. Each item in the tuple has the range 0-255

## 10、com.android.monkeyrunner.MonkeyImage.getRawPixelInt

  - 同getRawPixel，只是返回的是一个整型。
  - 用法：MonkeyImage.getRawPixelInt(x,y)
    - x：x偏移
    - y：y偏移 
  - 返回值: An unsigned integer pixel for x,y. The 8 high-order bits are A, followedby 8 bits for R, 8 for G, and 8 for B

## 11、com.android.monkeyrunner.MonkeyImage.getSubImage

  - 复制一个图片的矩形区域。
  - 用法：MonkeyImage.getSubImage(rect)
    - rect：A tuple (x, y, w, h)，x，y指定矩形区域的左上角，w为矩形宽，h为矩形高
  - 返回值：一个表示复制区域的图形对象

## 12、com.android.monkeyrunner.MonkeyDevice.getProperty

  - 在设备上给出变量的名称，返回变量的值。
  - 用法：MonkeyDevice.getProperty(key)
    - key：变量的名称（key列表参考http://developer.android.com/tools/help/MonkeyDevice.html#table1）
  - 返回值：变量的值

## 13、com.android.monkeyrunner.MonkeyDevice.getSystemProperty
  
  - getProperty的同义
  - 用法：MonkeyDevice.getSystemProperty(key)
    - key：系统变量的名称。
  - 返回值：系统变量的值

## 14、com.android.monkeyrunner.MonkeyDevice.drag

  - 在设备屏幕上模拟拖曳。
  - 用法：MonkeyDevice.drag(start,end,duration,steps)
    - start：拖曳开始坐标 
    - end：拖曳结束坐标点
    - duration：持续时间
    - steps：拖曳步骤
  - 返回值:nothing

## 15、com.android.monkeyrunner.MonkeyDevice.getHierarchyViewer

  - 获取设备的显示层次。
  - 用法：MonkeyDevice.getHierarchyViewer()
  - 返回值：一个HierarchyViewer类型的对象。

## 16、com.android.monkeyrunner.easy.By.id

  - 使用ID进行测试
  - 用法：easy_device.touch(By.id('id/digit7')，MonkeyDevice.DOWN_AND_UP)
    - id：控件的ID
  - 返回值:nothing

## 17、com.android.monkeyrunner.MonkeyDevice.installPackage

  - 在设备上安装应用包，如果该包已经存在，那么替换掉原来的。
  - 用法：MonkeyDevice.intallPackage(path)
    - path：安装包在本地的路径已经文件名。
  - 返回值：如果安装成功返回true，否则false

## 18、com.android.monkeyrunner.MonkeyDevice.instrument

  - 运行测试设备的指定包。
  - 用法：MonkeyDevice.instrument(className,args)
    - className：测试设备要执行的类，格式为packagename/classname
    - args：默认为空。参数传递给这个仪器的对象映射到一个字符串
  - 返回值：单个键值对，key-value

## 19、com.android.monkeyrunner.MonkeyDevice.reboot

  - 重启指定设备进入指定加载模式。
  - 用法：MonkeyDevice.reboot(into)
    - into：bootloader, recovery, or None
  - 返回值：nothing

## 20、com.android.monkeyrunner.MonkeyDevice.removePackage

  - 从设备删除指定的包，包括相关的数据已经缓存。
  - 用法：MonkeyDevice.removePackage(package)
    - package：指定要删除的包名
  - 返回值：删除成功则返回true

## 21、com.android.monkeyrunner.MonkeyImage.sameAs

  - 比较两个对象
  - 用法：MonkeyImage.sameAs(other,percent)
    - other：其他MonkeyImage对象
    - percent：百分比，取值为0.0-1.0
  - 返回值：如果一致返回true

## 22、com.android.monkeyrunner.MonkeyDevice.shell

  - 执行adb shell命令并返回结果。
  - 用法：MonkeyDevice.shell(cmd)
    - cmd：要执行的adb shell命令
  - 返回值：命令的输出

## 23、com.android.monkeyrunner.MonkeyRunner.loadImageFromFile

  - 加载文件
  - 用法：MonkeyRunner.loadImageFromFile(path)
    - path：文件的路径，运行monkeyrunner机器上的路径，而不是安卓设备的路径
  - 返回值：表示指定文件的MonkeyImage对象

## 24、com.android.monkeyrunner.MonkeyDevice.startActivity

  - 在设备上开始一个活动
  - 用法：MonkeyDevice.startActivity(uri,action,data,mimetype,categories,extras,component,flags)
    - uri：Intent的URI
    - action：Intent的动作
    - data：Intent的data URI
    - mimetype：Intent的MIME类型
    - categories：可迭代的数据结构，包含对Intent种类有定义的字符串
    - extras：Intent附加数据的dictionary
    - component：Intent的组件，本变量的使用会将Intent指向特定的Android包中的特定类
    - flags：一个可迭代的数据结构，包含控制Intent如何处理的标记
  - 返回值：nothings

## 25、com.android.monkeyrunner.MonkeyDevice.takeSnapshot

  - 获取设备的屏幕缓存，生成当前屏幕的截图
  - 用法：MonkeyDevice.takeSnapshot()
  - 返回值：一个MonkeyImage对象。

## 26、com.android.monkeyrunner.MonkeyDevice.touch

  - 对指定位置发送一个触摸事件
  - 用法：MonkeyDevice.touch(x,y,type)
    - x：发生触摸手势的水平位置，以实际设备像素为单位, 从屏幕左边为起始，以当前朝向为准
    - y：发生触摸手势的垂直位置，以实际设备像素为单位, 从屏幕左边为起始，以当前朝向为准
  - type：触摸事件类型，可用的值有DOWN，UP，和DOWN_AND_UP
  - 返回值：nothing

## 27、com.android.monkeyrunner.MonkeyDevice.type

  - 从键盘键入指定的字符串，这相当于字符串的每一个字符都执行一次press（keycode，DOWN_AND_UP）方法。
  - 用法：MonkeyDevice.type(message)
    - message：发送到键盘的字符串
  - 返回值:nothing

## 28、com.android.monkeyrunner.MonkeyDevice.press

  - 给指定key发送一个key事件
  - 用法：MonkeyDevice.press(name,type)
    - name：待发送的键码名称
    - type：触摸事件类型，如DOWN_AND_UP
  - 返回值：nothing

## 29、com.android.monkeyrunner.MonkeyDevice.wake

  - 唤醒设备的屏幕
  - 用法：MonkeyDevice.wake()
  - 返回值:nothing

## 30、com.android.monkeyrunner.MonkeyImage.writeToFile

  - 将MonkeyImage对象写入一个文件，
  - 用法：MonkeyImage.writeToFile(path,format)
    - path：输入的文件名，可选择的包含路径
    - format：目标格式，默认为png。
  - 返回值：如果输出成功返回true
