/* TestApp.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object TestApp {
  def main(args: Array[String]) {
    val logFile = "/Users/gnambiar/Programming/TestApp/logFile" //This should be a path pointing to a log file in your system 
    val conf = new SparkConf().setAppName("Test Application")  //Set the application name here and create a new Spark Configuration object
    val sc = new SparkContext(conf) // Create a Spark Context utilizing the conf that you just created
    val logData = sc.textFile(logFile, 2).cache() //c
    val numErrors = logData.filter(line => line.contains("error")).count()
    println("Lines with ERROR: %s".format(numErrors))
  }
}
