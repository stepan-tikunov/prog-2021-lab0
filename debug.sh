#!/bin/bash

cd "$(dirname "$0")" ;

jdb -sourcepath src/ -classpath bin/ edu.ifmo.tikunov.lab0.Main ;
