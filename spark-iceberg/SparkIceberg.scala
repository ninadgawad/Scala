package com.ninad

import org.apache.spark.sql.SparkSession

object SparkIceberg {

def main(args: Array[String]): Unit = {

  val spark = SparkSession.builder
  .appName("SparkIceberg App")
  .config("spark.sql.catalog.spark_catalog", "org.apache.iceberg.spark.SparkSessionCatalog")
  .config("spark.sql.catalog.spark_catalog.type", "hive")
  .config("spark.sql.catalog.local", "org.apache.iceberg.spark.SparkCatalog")
  .config("spark.sql.catalog.local.type", "hadoop")
  .config("spark.sql.catalog.local.warehouse", "/apache/iceberg/warehouse/diets")
  .getOrCreate()

  // Read the Iceberg table into a DataFrame
    val df: DataFrame = spark.read.format("iceberg").load("catalog.db.deit")

    // Display the details of the DataFrame
    df.show()
  }
}

