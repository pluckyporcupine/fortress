set -e
JAVA_HOME=$(readlink -f $(which java))
ANT_HOME=$(readlink -f $(which ant))
FORTRESS_HOME=/home/matt/Documents/Code/Java/fortress-java-9
./ant clean compile
