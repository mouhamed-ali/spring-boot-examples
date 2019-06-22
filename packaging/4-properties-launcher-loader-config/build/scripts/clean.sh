#!/bin/bash
#this script will clean a directory from the all the jar files (the directory fill path is a script argument)

clean(){

    for jar in `ls $1 | grep jar`
    do
        rm -fv $1/$jar
    done
}

## BEGIN

echo " -- Calling clean.sh using this parameters : $@"

if  [ "$#" -ne 1 ]
then
    echo 'you must pass only one parameter to this script'
    exit 101
fi

if [ -d $1 ]; then
    clean $1
else
    echo 'the passed argument is not a directory'
fi

## END