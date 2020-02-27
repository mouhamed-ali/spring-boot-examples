#!/bin/bash
#this script will copy all the project dependencies to the build directory

copyDependencies(){

    echo ' -- copying the new version'
    cp -v ./target/$1/* ./build/$2/
}

## BEGIN

echo " -- Calling copy-dependencies.sh using this parameters : $@"

if  [ "$#" -ne 2 ]
then
    echo 'you must pass the old and the new dependencies directories to this script'
    exit 104
fi

echo ' -- copying dependencies'

if [ ! -d "./build/$2" ]
then
    mkdir "./build/$2"
fi

copyDependencies $1 $2

## END
