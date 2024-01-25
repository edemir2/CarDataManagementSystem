#!/bin/bash

javac makeTestFile.java 
java makeTestFile checkCarData.java $1
javac $1_checkCarData.java
java $1_checkCarData sample_data3.txt sample_data3_expected_result.txt 400 1080 0.5 650

