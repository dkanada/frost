#! /bin/bash

for DIR in $(find -name "*.svg")
do
  FILE=${DIR##*/}
  sed -r -i 's:fill="#\w{3,6}":fill="#fff":' ${FILE}
done
