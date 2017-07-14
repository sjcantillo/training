#!/bin/bash

wget -O ocr.png --no-cookies --header "Cookie:WC=9708475-34593-jaw9ISkrkhUWYFNQ" \
	http://www.wechall.net/challenge/can_you_readme/gimme.php

tesseract ocr.png ocr -psm 7

SOLUTION=$(head -1 ocr.txt)

curl -b "WC=9708475-34593-jaw9ISkrkhUWYFNQ" -G -d "solution=$SOLUTION" -d "cmd=Answer" \
	http://www.wechall.net/challenge/can_you_readme/index.php
