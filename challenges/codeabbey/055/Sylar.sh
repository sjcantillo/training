#!/bin/bash

n1=$(head -1 conteoPalabras.txt)
for j in $n1; do

     n2=$(grep -o "$j" "conteoPalabras.txt")
     n2=$(echo "$n2" | wc -w)
     if [ "$n2" -gt 1 ]; then
        #echo "palabra!! $j"
        sed -i.old "s/$j//g" conteoPalabras.txt
        n1=$(head -1 conteoPalabras.txt)
        #echo "$n1\n"
        respuesta="${respuesta} $j"
     fi
done
#Ordenar palabras
arr2=$(for h in $respuesta; do
    echo "$h"
done | sort)
echo "$arr2"
respuesta=""
for k in $arr2; do
    respuesta="${respuesta} $k"
done
echo "$respuesta"
