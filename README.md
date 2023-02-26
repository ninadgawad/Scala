# Scala
Scala is a general-purpose programming language that runs on the Java Virtual Machine (JVM). It is a statically-typed language that combines the best features of object-oriented and functional programming. Here are a few basic steps to get started with Scala:

## Version:  [Download Link](https://www.scala-lang.org/download/all.html)
- Scala 3.2.2 : Current release: 3.2.2 & Released on Jan 30, 2023
- Scala 3.2.1
- Scala 3.2.0
- Scala 3.1.3
- Scala 3.1.2
- Scala 3.1.1
- Scala 3.1.0
- Scala 3.0.2
- Scala 3.0.1
- Scala 3.0.0
- Scala 2.13 : Current release: 2.13.10 & Released on Oct 13, 2022
- Scala 2.12 : Current release: 2.12.17 & Released on Sept 16, 2022

## Setup
- Install the Scala runtime on your machine. You can download the latest version of Scala from the official website (https://www.scala-lang.org/) or use a package manager like sdkman to install it.
- Set up your development environment. You can use any text editor or integrated development environment (IDE) that supports Scala. Some popular choices include IntelliJ IDEA, Eclipse, and Visual Studio Code.
- Write your first Scala program. A simple Scala program might look like this:
```scala
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
  }
}

```

## Key Concepts:

- **Compile** and run your program. You can use the Scala compiler (scalac) to compile your program, or you can use an IDE that has built-in support for Scala. To run your program, you can use the Scala interpreter (scala) or create a standalone JAR file and run it with the Java runtime.
- **Immutability** is not changing the state of variable once value is assgined
- **Expression** yields a vaule 
- **Statement** does some action 
- **Function**: A relation between a set of inputs and set of permissible outputs with the property that each input is related to exactly one output
- **Pure functions** evaluate to the same results for the same set of given inputs; these do not have any side effects and are reliable
- **Impure function** does not gurantee that same result for the set of given inputs, can have side effect in the system hence not reliable
- **Referential Transparency**: An expression or function is called referentially transparent is it can be replaced with its value, without changing the algorith, yielding the same output as when they were called without their value replacement
- **Higher Order Functions** takes function as inputs

## Scala Key features vs Java 
- **Concise and expressive syntax:** Scala has a more concise syntax that enables developers to write complex functionality with fewer lines of code.
- **Functional programming:** Scala supports functional programming features such as immutability, higher-order functions, and lazy evaluation.
- **Interoperability with Java:** Scala is fully interoperable with Java, allowing developers to use existing Java libraries in their Scala code.
- **Type inference:** Scala has a powerful type inference system that reduces the verbosity of the code and enables developers to write more concise code.
- **Case classes and pattern matching:** Scala has built-in support for case classes and pattern matching, which makes it easier to write and reason about code that performs data manipulation.
- **Actors-based concurrency:** Scala has a built-in actor model for concurrent programming, which provides an alternative to traditional Java thread-based concurrency.


## Scala REPL:
```scala
x = 10
y = 20
z = x +y
```

## Scala Collection
![Scala Collection](https://github.com/ninadgawad/Scala/blob/main/ScalaCollectionv1.png)

## List 
![List](https://github.com/ninadgawad/Scala/blob/main/ScalaCollectin_List_v2.png)

## RDD's - Resilent Distributed Datasets
- Help parallel process
- Performance 
- Lazy Evaluation 

## RDD Transdormation
- map 
- flatmap 
- filter 
- distinct 
- sample

## Sample Functional Programming
val rddList = sc.parallelize(List(1,2,3,4))

val cubes = rdd.map(x=>x*x*x)

### Output
1,8,27,64

### RDD Actions 
- collect 
- count 
- countByValue
- top
- take 
- reduce

### DataFrame

### DataSets


## Scala with Saprk example:
Apache Spark is a popular big data processing framework that is well-suited for use with Scala. Spark provides a high-level API for distributed data processing that is easy to use and efficient. 

Here's a simple example in Scala that demonstrates how to use Spark to process data:
```scala
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleApp {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val data = sc.parallelize(Seq(1, 2, 3, 4, 5))
    val result = data.map(x => x * x).sum()
    println(s"Result: $result")
    sc.stop()
  }
}
```

In this example, we create a SparkConf object to configure the application and a SparkContext to access the Spark cluster. The parallelize method is used to create a distributed data set from a local data structure (in this case, a sequence). The map transformation is applied to the data set to perform a computation (in this case, squaring each value), and the sum action is used to compute the sum of the result. The result is then printed to the console.

This simple example demonstrates how easy it is to use Scala and Spark together to process big data.


## Reference Links:
https://www.scala-lang.org/download/scala3.html
https://scastie.scala-lang.org/




