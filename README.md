# Scala
Scala is a general-purpose programming language that runs on the Java Virtual Machine (JVM). It is a statically-typed language that combines the best features of object-oriented and functional programming. Here are a few basic steps to get started with Scala:

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
- **Compile** and run your program. You can use the Scala compiler (scalac) to compile your program, or you can use an IDE that has built-in support for Scala. To run your program, you can use the Scala interpreter (scala) or create a standalone JAR file and run it with the Java runtime.
- **Expression** yields a vaule 
- **Statement** does some action 
- **Function**: A relation between a set of inputs and set of permissible outputs with the property that each input is related to exactly one output
- **Pure functions** evaluate to the same results for the same set of given inputs; these do not have any side effects and are reliable
- **Impure function** does not gurantee that same result for the set of given inputs, can have side effect in the system hence not reliable


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


## Reference Links:
https://www.scala-lang.org/download/scala3.html




