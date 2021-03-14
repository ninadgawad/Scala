case class  Currency(code:String, amount:Double, toUSD:Double)


object ScalaFunctions extends App{

  implicit def stringToCurrency(money: String):Currency={
    val Array(code:String, value:String) = money.split("\\s") // Split on spaces 
    val amountAsDouble = value.toDouble
    code match {
      case "USD" => Currency("USD", amountAsDouble, amountAsDouble)
      case "NZD" => Currency("USD", amountAsDouble, amountAsDouble * (1/1.3))
    }
  }

  // Does implict conversion since the function is implicit
  val inr:Currency = "NZD 50"
  println(inr)
  
}
