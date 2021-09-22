#!/bin/bash

cd "$(dirname "$0")";
mkdir bin 2>/dev/null;
javac Main.java -d bin/;
cd bin;
jar cfm lab0.jar ../MANIFEST.mf Main.class;
echo "Compiled successfully, lab0.jar and Main.class are stored in bin/directory.";
