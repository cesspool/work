#! /bin/bash

WAR_HOME=/home/igor/JProjects/diplom/work/target
WAR_NAME=webApp-1.0-SNAPSHOT.war
APP_NAME=webApp
asadmin deploy --name $APP_NAME --contextroot "/webApp" $WAR_HOME/$WAR_NAME
