#! /bin/bash

SIZES="48 72 96 144 384"
EXPORT="../app/src/main/res"

for FILE in *.svgo
do
  NAME=${FILE%.*}
  mv ${NAME}.svgo ${NAME}.svg
  for SIZE in $SIZES
  do
    inkscape --export-png=${NAME}.png --export-width=$SIZE --export-height=$SIZE ${NAME}.svg
    case $SIZE in
      48)
        mv ${NAME}.png ${EXPORT}/drawable-mdpi/
        ;;
      72)
        mv ${NAME}.png ${EXPORT}/drawable-hdpi/
        ;;
      96)
        mv ${NAME}.png ${EXPORT}/drawable-xhdpi/
        ;;
      144)
        mv ${NAME}.png ${EXPORT}/drawable-xxhdpi/
        ;;
      384)
        cp ${NAME}.png ${EXPORT}/drawable-xxxhdpi/
        mv ${NAME}.png ${EXPORT}/drawable-nodpi/nodpi_${NAME}.png
        ;;
    esac
  done
done
