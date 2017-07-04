#!/bin/bash

# run with ./go.sh start-local p1 "this is a long string" "and another"

CMD="$1"
shift # shifts the args by one so CMD is removed

function log() {
    local level=$1
    local message=$2
    echo -e "$level: $message"
}

function log_error() {
    local message=$1
    log "\nERROR" "$message\n"
}

function unrecognisedCommand() {
    local command=$1
    log_error "You typed a command that I did not recognise - [$command]"
}

function help() {
    echo -e "Usage: ./go.sh start-local p1 \"this is a long string\" \"and another\"\n"
}

function start-local() {
    echo "start-local"
    echo "1st param [$1]"
    echo "2nd param [$2]"
    echo "3rd param [$3]"
}

echo "Executing [$CMD]..."

if [ "$(type -t $CMD)" = 'function' ]; then
    $CMD "$@"
else
    unrecognisedCommand $CMD
    help
fi

