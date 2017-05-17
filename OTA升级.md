### 测试BOTO安装， OTA升级步骤
1. **存在的问题：**
   - _安装过程中，在安装system data文件时，选错了硬盘分区，选择_ **cnacel** _依然拷贝文件并进行到下一步。_
   - _OTA中系统版本， 设置中系统版本，以及更新新的镜像的版本号没有统一（目前设置为未知， OTA有一个版本号，但是和实际底层更新的没有对应）。_
   - _安装帮助提示需要增加， 开机启动刷屏和先进入debug模式需要去掉。_
2. **验证方式**
   - _安装后为上周五（2016.09.23）版本， 升级后为今天版本， 查看相应PATH， 修改了设置中，声音/显示相关位置，修改了双击空白背景最大化问题，更新前确认问题存在， 更新后上述问题消失。_
3. **安装升级方法和步骤**
   1. 基于androidx86 multiwindow分支打wjx的临时补丁
      - 将/home/lh/wjx/multiwindow/bootable/newinstaller/ota.patch拷贝到x86源码/bootable/newinstaller/下
      - git apply ota.patch
   2. 编译系统镜像
      - make oto_img
      - 生成镜像文件为out/target/product/x86_64/android_x86_64_oto.img
   3. 安装系统
      - 将android_x86_64_oto.img dd到u盘
      - 确保待安装机器硬盘有3个空闲分区，分别用作EFI/system/data安装过程中使用
      - 选择EFI USB引导安装系统， 安装系统后，需要确定为EFI HD为第一启动项进入系统
   4. 编译升级压缩包
      - make update_zip (此步骤应该仅仅是打包已存在文件，所以如果repo sync有改动，需要先make oto_img或make iso_img确保生成的文件为最新）
      - 生成的压缩文件为out/target/product/x86_64/openthos_V1.0.zip （openthos_V1.0名称为bootable/newinstaller/otoinit/version配置的信息）
   5. 升级系统
      - 目前不考虑app部分
      - 创建/data/media/0/System_OS/目录
      - 将编译的openthos_V1.0.zip拷贝到该目录下 adb push openthos_V1.0.zip /data/media/0/System_OS/
      - 创建update文件，文件中第一行存储要升级的文件名， 第二行为1（ls openthos_V1.0.zip > update && echo 1 >> update)
      - 重启系统升级，根据两次版本的异同确认是否升级成功
