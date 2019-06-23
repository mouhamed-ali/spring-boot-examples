#!/bin/bash

# After building the project from build.sh, you can run this script. this script will load config from the loader.properties file
#TODO : check why this script doesn't work if we build the project here (this script) ?
#TODO : why he debug mode (loader.debug=true) doesn't work ?

mainClass='org.springframework.boot.loader.PropertiesLauncher'
classPath='application.jar'
java -cp ${classPath}  ${mainClass}