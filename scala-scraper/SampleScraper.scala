import net.ninad.SampleScraper

object SampleScraper {
  def main(args: Array[String]): Unit = {

    val browser = JsoupBrowser()
    val doc = browser.get("https://en.wikipedia.org/wiki/Scala_(programming_language)")
    val html = doc.toHtml
    println(html)
  }
}
