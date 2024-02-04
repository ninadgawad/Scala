package com.ninad

import org.apache.avro.file.DataFileReader
import org.apache.avro.generic.GenericRecord
import org.apache.avro.specific.SpecificDatumReader
import com.sksamuel.avro4s.{AvroInputStream, AvroSchema}

object ScalaAvroAnalysis {

  case class Movie(title: String, category: String)

  def main(args: Array[String]): Unit = {
    val avroSchema = AvroSchema[Movie]

    val inputFile = "movies.avro"
    val dataFileReader = new DataFileReader(new java.io.File(inputFile), new SpecificDatumReader[GenericRecord])

    var categoryCountMap: Map[String, Int] = Map.empty

    while (dataFileReader.hasNext) {
      val avroInputStream = AvroInputStream.data[Movie](dataFileReader.next, avroSchema)
      avroInputStream.iterator.foreach { movie =>
        val currentCount = categoryCountMap.getOrElse(movie.category, 0)
        categoryCountMap += (movie.category -> (currentCount + 1))
      }
      avroInputStream.close()
    }

    dataFileReader.close()

    val mostCommonCategory = categoryCountMap.maxBy(_._2)._1

    println(s"The most common movie category is: $mostCommonCategory")
  }
}
