#! /bin/bash

DRAWABLE='../app/src/main/res/xml/drawable.xml'
ICONPACK='../app/src/main/res/values/iconpack.xml'
STRING="    <item drawable=${FILE}/>"
STRING="        <item>${FILE}</item>"

SIZES="48 72 96 144 384"
EXPORT='../app/src/main/res'

for DIR in $(find -name "*.svg")
do
  FILE=${DIR##*/}
  for SIZE in $SIZES
  do
    inkscape --export-png=${DIR%.*}.png --export-width=$SIZE --export-height=$SIZE $DIR
    case $SIZE in
      48)
        mv ${DIR%.*}.png ${EXPORT}/drawable-mdpi/
        ;;
      72)
        mv ${DIR%.*}.png ${EXPORT}/drawable-hdpi/
        ;;
      96)
        mv ${DIR%.*}.png ${EXPORT}/drawable-xhdpi/
        ;;
      144)
        mv ${DIR%.*}.png ${EXPORT}/drawable-xxhdpi/
        ;;
      384)
        cp ${DIR%.*}.png ${EXPORT}/drawable-xxxhdpi/
        mv ${DIR%.*}.png ${EXPORT}/drawable-nodpi/nodpi-${FILE%.*}.png
        ;;
    esac
  done
done
