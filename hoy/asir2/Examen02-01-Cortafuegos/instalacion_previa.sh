#!/bin/bash

sudo apt-get update -y
sudo apt-get upgrade -y
sudo apt-get install netcat -y
sudo apt-get install apache2 -y
history -c
rm ~/.bash_history
sudo shutdown -r now