#! /bin/bash

SVGDIR="../icons/"
ICPACK_PRE='        <item>'
ICPACK_SUF='</item>\n'
DRAWABLE_PRE='    <item drawable="'
DRAWABLE_SUF='" />\n'

printf '<?xml version="1.0" encoding="utf-8"?>\n<resources>\n    <string-array name="icon_pack" translatable="false">\n' > iconpack.xml
printf '<?xml version="1.0" encoding="utf-8"?>\n<resources>\n    <version>1</version>\n' > drawable.xml

for DIR in $(find ${SVGDIR} -name "*.svg")
do
  FILE=${DIR##*/}
  NAME=${FILE%.*}
  printf "${ICPACK_PRE}${NAME}${ICPACK_SUF}" >> iconpack.xml
  printf "${DRAWABLE_PRE}${NAME}${DRAWABLE_SUF}" >> drawable.xml
done

printf '    </string-array>\n</resources>\n' >> iconpack.xml
printf '</resources>\n' >> drawable.xml
