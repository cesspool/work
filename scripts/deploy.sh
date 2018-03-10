#! /bin/bash
. ./env.sh
WAR_HOME=$PRJ_HOME/target
WAR_NAME=webApp-1.0-SNAPSHOT.war
APP_NAME=webApp
asadmin deploy --name $APP_NAME --contextroot "/webApp" $WAR_HOME/$WAR_NAME
