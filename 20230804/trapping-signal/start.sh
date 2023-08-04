#!/bin/bash

greet() {
    echo "Docker container stop"
    exit
}

trap greet SIGTERM

while true; do
    sleep 10
done
