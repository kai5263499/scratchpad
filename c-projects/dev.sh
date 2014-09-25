#!/bin/sh

  # Update Debian package index.
  sudo apt-get update -y

  # Install required Debian packages.
  sudo apt-get install -y gcc git-core make valgrind

