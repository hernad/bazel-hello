#!/bin/sh

export ANDROID_HOME=$HOME/Android/Sdk


# https://docs.bazel.build/versions/master/tutorial/android-app.html

bazel build //App-A-Android/src/main:main --subcommands


bazel mobile-install //App-A-Android/src/main:main


