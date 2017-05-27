#! /bin/bash

EXPORT="../icons"
ICON="../icons"

for DIR in $(find ${ICON} -name "*.svg")
do
  FILE=${DIR##*/}
  sed -r 's:fill="#\w{3,6}":fill="#fff":' $FILE > ${EXPORT}/${FILE}
done
