#!/bin/bash
#this script will configure and run our application

run(){

    cd $1
    local classPath='./'$2
    local jvmProperties=" -Dloader.path=./$3 \
                          -Dloader.home=.    \
                          -Dloader.debug=true   \
                          -Dloader.main=org.spring.boot.examples.packaging.Application"

    #Dloader.home is the location of external configuration if not on classpath, and also the base path for any relative paths in the loader path}. Defaults to current working directory

    local mainClass='org.springframework.boot.loader.PropertiesLauncher'

    echo
    echo --------------------------
    echo "classPath             : $classPath"
    echo "jvmProperties         : $jvmProperties"
    echo "mainClass             : $mainClass"
    echo "current directory     :" $(pwd)
    echo --------------------------

    java -cp ${classPath} \
         ${jvmProperties} \
         ${mainClass}

}


## BEGIN

echo " -- Calling run.sh using this parameters : $@"

if  [ "$#" -ne 3 ]
then
    echo 'you must pass three arguments to this script'
    exit 105
fi

if [[ ! -d $1 ]] || [[ ! -d $1/$3 ]] ; then

    echo 'one of the passed argument is not a directory'
    exit 106
fi

if [ ! -f $1/$2 ]; then

    echo 'the passed argument is not a jar file'
    exit 107
fi

run $1 $2 $3

## END