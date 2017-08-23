## 安装windows+openthos双系统
  - 分区
    - uefi分区(2G) 里面有efi相关的文件，openthos的system.sfs文件，以及用于重置和升级系统的相关脚本，
    - oto_data分区（ext4, 8G）openthos的/data目录
    - windows分区（ntfs, 100G）
    - data分区（exfat，剩下所有空间）
  - ubuntu分区完成后，先安装windows，安装过程中选择自定义安装，其中需要将分区3（100G）先删除，再新建，点击确定后windows会自动划分出另外的三个分区，选择主分区安装
  - 手动安装openthos(进入boot界面后，按F2，选择normal install安装模式，选择manual install安装，根据提示分别在sda1\sda2\最后一个分区中安装opentohos）
  - 可参考文档https://github.com/openthos/userguide-analysis/blob/master/%E4%B8%80.%E5%AE%89%E8%A3%85.md
## 安装windows+ubuntu双系统
  - 分区
    - openthos 
      - sda1 2G fat32 + sda2 10G ext4 + sda3 100G ext4
    - ubuntu 
      - sda4 200G ext4 + sda5 50G swap
      - 不安装启动项
  - openthos同样是手动安装
    
