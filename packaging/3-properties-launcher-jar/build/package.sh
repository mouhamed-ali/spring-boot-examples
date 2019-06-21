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

# deleting current jars
deleteOldVersion(){
    for jar in `ls ./build/*.jar`
    do
        rm -fv $jar
    done
}

package(){
    mvn clean package -DskipTests
}

getDeliveryFileName(){

    jarName=$(ls ./target | grep .-dev.jar*)
    echo "-- the delivery file is : $jarName"
}

copyNewVesion(){

    echo ' -- copying the new version'
    cp -v ./target/$1 ./build/$2
}

run(){

    cd $buildDirectory
    local classPath='./'$applicationName
    local jvmProperties=" -Dloader.path=lib,./externalLibrairies,./zip \
                          -Dloader.home=.    \
                          -Dloader.debug=true   \
                          -Dloader.main=org.spring.boot.examples.packaging.Application"

    #Dloader.home is the location of external configuration if not on classpath, and also the base path for any relative paths in the loader path}. Defaults to current working directory
    local mainClass='org.springframework.boot.loader.PropertiesLauncher'
    local args=$1

    echo
    echo --------------------------
    echo "classPath             : $classPath"
    echo "jvmProperties         : $jvmProperties"
    echo "mainClass             : $mainClass"
    echo "args                  : $args"
    echo "current directory     :" $(pwd)
    echo --------------------------

    java -cp ${classPath} \
         ${jvmProperties} \
         ${mainClass} \
         ${args}

}

####    BEGIN

init

deleteOldVersion

printf '\n--  Start Maven packaging \n'
package || { echo "packaging problem occurred , return status : $?"; exit 101;}

getDeliveryFileName

applicationName=application.jar
copyNewVesion $jarName $applicationName

printf '\n\n -- this bean will be loaded from the original application classpath'
run 'mockSender John Hello_World_!!!'

printf '\n\n -- this bean will be loaded from the an external jar file'
run 'externalSender Jerome Hello_World_!!!'

printf '\n\n -- this bean will be loaded from an external zip file'
run 'smtpSender Jack Hello_World_!!!'

return=$?
printf '\nthe return value is : '$return

####    END