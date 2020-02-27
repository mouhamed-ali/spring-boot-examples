#!/bin/bash
#this script will copy the the generated jar archive to the build directory

copyArchive(){

    cp -v ./target/$1 ./build/$2
}

## BEGIN

echo " -- Calling copy-archive.sh using this parameters : $@"

if  [ "$#" -ne 2 ]
then
    echo 'you must pass the archive old and new names to this script'
    exit 103
fi

echo ' -- copying the archive'
copyArchive $1 $2

## END
