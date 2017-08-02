#!/bin/bash
read -r n1
end="$(seq -s ' ' 1 "$n1")"

for i in $end
do
	read -r n2 
	l1=$(factor "$n2"|cut -d ':' -f 2|cut -c2- |tr ' ' '*')
	respuesta="${respuesta} $l1"
	echo "$i"
done
echo "$respuesta"
