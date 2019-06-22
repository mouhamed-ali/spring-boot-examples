#!/bin/bash
#this script will the mvn clean package command to build the jar application

package(){

    cd $1 | mvn clean package -DskipTests
}

## BEGIN

echo " -- Calling package.sh using this parameters : $@"

if  [ "$#" -ne 1 ]
then
    echo 'you must pass only one parameter to this script'
    exit -1
fi

if [ -d $1 ]; then

    echo " --  Start Maven packaging"
    package $1 || { echo "packaging problem occurred , return status : $?"; exit 102;}

else
    echo 'the passed argument is not a directory'
fi

## END