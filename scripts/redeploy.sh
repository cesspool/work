#! /bin/bash

WAR_HOME=/home/paul/IdeaProjects/work/target
WAR_NAME=webApp-1.0-SNAPSHOT.war
APP_NAME=webApp

asadmin redeploy --name $APP_NAME $WAR_HOME/$WAR_NAME

