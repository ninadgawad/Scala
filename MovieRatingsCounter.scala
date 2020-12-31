import org.apache.spark._
import org.apache.log4j._

object MovieRatingsCounter {

def main(args: Array[String]) {
  Logger.getLogger("org").setLevel(Level.INFO)
  val sc = new SparkContext("local[*]", "MovieRatingsCounter")
  val movieLines = sc.textFile("u.data")
  val movieRatings = movieLines.map(x => x.split("\t")(2))
  val results = movieRatings.countByValue()
  val sortedResults = results.toSeq.sortBy(_._1)
  sortedResults.foreach(println)
}

}
