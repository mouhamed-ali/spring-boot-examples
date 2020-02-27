#!/bin/bash

init(){

    buildDirectory=`pwd`
    cd ..
    rootDirectory=$(pwd)

    echo --------------------------
    echo "build directory       : $buildDirectory"
    echo "root directory        : $rootDirectory"
    echo --------------------------
}


getArchiveFileName(){

    echo `ls ./target | grep .-dev.jar`
}

####    BEGIN

buildLibDir=library
buildJarName=application.jar

init

source  $buildDirectory/scripts/clean.sh $buildDirectory

source  $buildDirectory/scripts/clean.sh $buildDirectory/$libDir

bash    $buildDirectory/scripts/package.sh $rootDirectory

jarName=$(getArchiveFileName)
echo " -- the archive file name is : $jarName"

$buildDirectory/scripts/copy-archive.sh $jarName $buildJarName

$buildDirectory/scripts/copy-dependencies.sh lib $buildLibDir

$buildDirectory/scripts/run.sh $buildDirectory $buildJarName $buildLibDir

return=$?
printf "\nthe return value is : $return \n"

####    END