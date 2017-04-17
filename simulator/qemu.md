- sudo apt-get install ovmf

- qemu-system-x86_64 -enable-kvm -m 2.5G  -vga std -serial stdio -bios /usr/share/ovmf/OVMF.fd -drive file=android_x86_64_oto.img
