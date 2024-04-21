import net.ruippeixotog.scalascraper.browser.JsoupBrowser

object SampleScraper {
  def main(args: Array[String]): Unit = {
    // initialize the Jsoup-backed browser
    val browser = JsoupBrowser()
    // download the target page
    val doc = browser.get("https://en.wikipedia.org/wiki/Scala_(programming_language)")

    // extract its source HTML and print it
    val html = doc.toHtml
    println(html)
  }
}
