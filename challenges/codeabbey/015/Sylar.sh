#!/bin/bash
v1=$(grep -Eo '[0-9]+' max.txt | sort -nr | head -1)
v2=$(grep -Eo '(^|-)[0-9]+' max.txt | sort -nr | tail -1)
echo "$v1 $v2"
