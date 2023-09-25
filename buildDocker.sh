#!/bin/bash
# Author: Ignacio Illanes Bequer

# package the application

./mvnw clean package -DskipTests
mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

docker build -t $container_name:$version_tag .
