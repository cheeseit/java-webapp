#! /bin/bash

mvn install
mvn clean
mvn package
mvn tomcat:redeploy
