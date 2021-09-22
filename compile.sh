#!/bin/bash

cd "$(dirname "$0")" ;

rm -r bin 2>/dev/null ;
mkdir bin 2>/dev/null ;
javac -s src/ -d bin/ $(find src -name "*.java") >/dev/null &&
jar cfm bin/app.jar MANIFEST.mf -C bin/ $(cd bin/ && find . -name "*.class") >/dev/null &&
echo "Compiled successfully, app.jar and *.class files are stored in bin/ directory." ;
