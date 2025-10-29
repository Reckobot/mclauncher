#!/bin/bash

sh decompile.sh
sh init.sh
sh applyPatches.sh
mvn clean package