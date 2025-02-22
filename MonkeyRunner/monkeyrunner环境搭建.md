# monkeyrunner环境搭建

## 配置jdk

  - 下载地址:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
  
  - 选择下载版本:jdk-8u111-linux-x64.tar.gz
  
  - 解压文件:
 
  ```
  tar -zxvf jdk-8u111-linux-x64.tar.gz
  ```
  - 重命名文件并移动到/usr/lib下面: 
 
  ```
  mv jdk1.8.0_111 /usr/lib/jdk8
  ```
  - 配置环境变量
  
  ```
  sudo vi /etc/profile
  ```
  - 添加以下几行
  
  ```   
  export JAVA_HOME=/usr/lib/jdk8
  export JRE_HOME=$JAVA_HOME/jre    
  export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib 
  export PATH=$JAVA_HOME/bin:$PATH 
  ```  
  
  - 使配置生效
  
  ```
  source /etc/profile
  ```
  - 验证是否配置成功
  
  ```
  java -version
  ```
  出现jdk版本信息，则配置成功
   
## 配置Android Sdk
   
### 下载安装Android Studio(或者直接下载工具Sdk，不用这么麻烦）
 
   - 下载地址:http://www.android-studio.org/
   
   - 选择下载版本:android-studio-ide-145.3360264-linux.zip
   
   - 解压到/opt:
   
   ```
   unzip android-studio-ide-145.3360264-linux.zip
   mv android-studio /opt
   ```
   - 运行
   
   ```
   chmod 777 android-studio
   vim android-studio/bin/studio.sh
   ##在第一行添加JAVA_HOME="/usr/bin/jdk8"以防止运行时提示找不到jdk路径
   ./android-studio/bin/studio.sh
   ```
   - 配置SDK
       
      - 选择SDK Manager，下载android5.1版本
      - 安装 SDK Platform-Tools
      - 安装 Android SDK Tools
      - 配置环境变量
   
   ```
   sudo vi /etc/profile
   export PATH=$PATH:/opt/Android/Sdk/tools:/opt/Android/Sdk/platform-tools
   ```
   
   - 验证是否成功
   
   ```
   android list target
   ```
   能够查看到android5.1版本对应的id
   
   若不成功，尝试
   
   ```
   sudo apt-get install lib32z1 lib32ncurses5  lib32stdc++6
   ```
   
### 下载安装lantern（可装可不装）

  - 下载地址:https://github.com/getlantern/lantern
  
  - 选择下载版本
  
  - 安装
   
  ```
  sudo dpkg -i lantern-installer-beta-64-bit.deb 
  sudo chmod 777 /usr/bin/lantern
  ```
  - 启动
   
  ```
  lantern
  ```
