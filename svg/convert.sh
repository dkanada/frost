#! /bin/bash

DRAWABLE='../app/src/main/res/xml/drawable.xml'
ICONPACK='../app/src/main/res/values/iconpack.xml'
STRING="    <item drawable=${FILE}/>"
STRING="        <item>${FILE}</item>"

SIZES="48 72 96 144 384"
DIR='../app/src/main/res'

for FILE in *.svg
do
  for SIZE in $SIZES
  do
    inkscape --export-png=${FILE%.*}.png --export-width=$SIZE --export-height=$SIZE $FILE
    case $SIZE in
      48)
        mv ${FILE%.*}.png ${DIR}/drawable-mdpi/
        ;;
      72)
        mv ${FILE%.*}.png ${DIR}/drawable-hdpi/
        ;;
      96)
        mv ${FILE%.*}.png ${DIR}/drawable-xhdpi/
        ;;
      144)
        mv ${FILE%.*}.png ${DIR}/drawable-xxhdpi/
        ;;
      384)
        cp ${FILE%.*}.png ${DIR}/drawable-xxxhdpi/
        mv ${FILE%.*}.png ${DIR}/drawable-nodpi/
        ;;
    esac
  done
done
