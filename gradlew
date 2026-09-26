#!/usr/bin/env bash

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Attempt to set APP_HOME
# Resolve links: $0 may be a symlink
PRG="$0"
# Need this for relative symlinks.
while [ -h "$PRG" ] ; do
    ls -ld "$PRG"
    link=`ls -l "$PRG" | awk '{print $NF}'`
    case "$link" in
      /*) PRG="$link" ;;
      *) PRG=`dirname "$PRG"`"/$link" ;;
    esac
done
SAVE="$(pwd)"
cd "$(dirname "$PRG")" >/dev/null
APP_HOME="$(pwd -P)"
cd "$SAVE" >/dev/null

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS=''-Xmx64m''

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD="maximum"

warn () {
    echo "$*"
}

die () {
    echo
    echo "$*"
    echo
    exit 1
}

# OS specific support (must be 'true' or 'false').
IS_CYGWIN=false
IS_MINGW=false
IS_MSYS=false
IS_WSL=false
IS_MLS=false
case "$(uname)" in
  CYGWIN* )
    IS_CYGWIN=true
    ;;
  Darwin* )
    IS_MACOSX=true
    ;;
  MSYS* )
    IS_MSYS=true
    ;;
  MINGW* )
    IS_MINGW=true
    ;;
  NMSYS* )
    IS_NMSYS=true
    ;;
  Linux* )
    IS_LINUX=true
    ;;
esac

# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD="$JAVA_HOME/jre/sh/java"
    else
        JAVACMD="$JAVA_HOME/bin/java"
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME"
    fi
else
    JAVACMD="java"
    which java >/dev/null 2>&1 || die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH."
fi

# Increase the maximum file descriptors if we can.
if [ "$IS_CYGWIN" = "true" -o "$IS_MINGW" = "true" ] ; then
    MAX_FD_LIMIT=`getconf ARG_MAX 2>/dev/null`
else
    MAX_FD_LIMIT=65535
fi

if [ $? -eq 0 ] ; then
    if [ "$MAX_FD" = "maximum" -o "$MAX_FD" = "max" ] ; then
        MAX_FD="$MAX_FD_LIMIT"
    fi
    ulimit -n $MAX_FD
fi

if [ "$VERBOSE" = "true" ] ; then
    echo "Max file descriptors: $MAX_FD"
fi

# Collect all arguments for the java command, stacking in reverse order.
for arg in "$@" ; do
    if [ "$arg" = "--" ] ; then
        shift
        break
    fi
    shift
    set -- "$arg" "$@"
done

for arg in "$@" ; do
    expr "$arg" : "^-" > /dev/null
    if [ $? -ne 0 ] ; then
        classpath_arg="$classpath_arg $arg"
    else
        case "$arg" in
            -d32) set -- "$@" "-Xmx32m" ;;
            -d64) set -- "$@" "-Xmx64m" ;;
        esac
        set -- "$@" "$arg"
    fi
done

# Escape application args
save () {
    for i do printf %s\\n "$i" | sed "s/'/'\\\\''/g;1s/^/'/;\$s/\$/'" ; done
    echo " "
}
APP_ARGS=`save "$@"`

# Collect all arguments for the java command, following the shell quoting and substitution rules
eval set -- $DEFAULT_JVM_OPTS $JAVA_OPTS $GRADLE_OPTS \"-Dorg.gradle.appname=$APP_BASE_NAME" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$APP_ARGS"

exec "$JAVACMD" "$@"
