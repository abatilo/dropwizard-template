#!/bin/sh

JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"

java $JAVA_OPTS \
  -jar root.jar \
  server \
  local.yaml
