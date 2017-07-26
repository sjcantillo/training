#!/bin/bash
read -r n1
read -p "$n1" -r name
suma=0
for i in $name; do
    suma=$((suma + i))
done
echo "Es $suma!"
