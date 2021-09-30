#!/bin/bash

cd "$(dirname "$0")" ;

rm bin/app.jar $(find bin -name "*.class") 2>/dev/null ;
mkdir bin 2>/dev/null ;
javac -g -s src/ -d bin/ $(find src -name "*.java") &&
jar cfm bin/app.jar MANIFEST.mf -C bin/ $(cd bin/ && find . -name "*.class") &&
echo "Compiled successfully, app.jar and *.class files are stored in bin/ directory." ;
