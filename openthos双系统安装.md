## 安装windows+openthos双系统
  - 分区
    - uefi分区(2G) 里面有efi相关的文件，openthos的system.sfs文件，以及用于重置和升级系统的相关脚本，
    - oto_data分区（ext4, 8G）openthos的/data目录
    - windows分区（ntfs, 100G）
    - data分区（exfat，剩下所有空间）
  - ubuntu分区完成后，先安装windows，安装过程中选择自定义安装，其中需要将分区3（100G）先删除，再新建，点击确定后windows会自动划分出另外的三个分区，选择主分区安装
  - 手动安装openthos（目前手动安装后无法启动openthos，需要U盘启动引导）
## 安装windows+ubuntu双系统
  - 分区
    - ubuntu 1G fat32 + 200G ext4 + 50G swap
    - openthos 2G fat32 + 10G ext4 + 100G ext4
    
