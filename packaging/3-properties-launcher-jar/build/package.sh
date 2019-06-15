#!/bin/bash

buildDirectory=`pwd`

cd ..

rootDirectory=$(pwd)

echo --------------------------
echo Start Maven packaging
echo --------------------------

mvn clean package -DskipTests

cd target

jarName=$(ls . | grep *.jar)

echo --------------------------
echo "the build directory name is : $buildDirectory"
echo "the root directory is       : $rootDirectory"
echo "the jar name is             : $jarName"
echo --------------------------

echo --------------------------
echo Start copying dependencies
echo --------------------------

# adding the lib directory to our jar file
jar cf $jarName lib

# showing the jar content
jar tf $jarName

