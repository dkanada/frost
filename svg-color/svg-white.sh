#! /bin/bash

EXPORT="../svg-white"

for DIR in $(find -name "*.svg")
do
  FILE=${DIR##*/}
  sed -r 's:fill="#\w{3,6}":fill="#fff":' $FILE > ${EXPORT}/$FILE
done
