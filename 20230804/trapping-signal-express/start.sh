#!/bin/bash

greet() {
    echo "Docker container stop"
    exit
}

trap greet SIGBREAK

npm start
