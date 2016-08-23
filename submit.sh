SPARK_HOME=/Users/cwang/Documents/3rdParty/spark-1.5.0-bin-hadoop2.6

# JAR containing a simple hello world
JARFILE=`pwd`/target/scala-fun-1.0-SNAPSHOT.jar

# Run it locally
${SPARK_HOME}/bin/spark-submit --class cj.playground.spark.HelloWorld --master local $JARFILE
