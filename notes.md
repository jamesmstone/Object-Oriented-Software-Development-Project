d exec -it eclipse bash
sudo dpkg --add-architecture i386
sudo apt-get update
sudo apt-get install libxxf86vm1:i386
sudo apt-get install x11-xserver-utils
sudo apt-get install libglu1-mesa:i386
sudo apt-get install libglu1-mesa

May not need to run below command:
sudo apt-get install libgtk2.0-0:i386 libxxf86vm1:i386 libsm6:i386 lib32stdc++6

## one command
dpkg --add-architecture i386 && apt-get update && apt-get install libxxf86vm1:i386 \
                x11-xserver-utils \
                libglu1-mesa:i386 \
                libglu1-mesa \
                -y
