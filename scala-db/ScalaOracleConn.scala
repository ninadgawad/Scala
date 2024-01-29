import java.sql.{Connection, DriverManager, ResultSet, Statement}

object ScalaOracleConn {
  def main(args: Array[String]): Unit = {
    // JDBC URL, username, and password of Oracle database
    val jdbcUrl = "jdbc:oracle:thin:@//hostname:psort/service"
    val username = "user"
    val password = "password"

    // Load the Oracle JDBC driver
    Class.forName("oracle.jdbc.driver.OracleDriver")

    // Establish a connection
    var connection: Connection = null
    var statement: Statement = null
    var resultSet: ResultSet = null

    try {
      connection = DriverManager.getConnection(jdbcUrl, username, password)

      // Create a statement
      statement = connection.createStatement()

      // Execute a query
      val query = "SELECT * FROM STARS"
      resultSet = statement.executeQuery(query)

      // Process the result set
      while (resultSet.next()) {
        val column1Value = resultSet.getString("starId")
        val column2Value = resultSet.getString("starName")
        // Add more columns as needed

        // Process the retrieved data, e.g., print it
        println(s"STAR ID: $starId, Star Name: $starName")
      }

    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      // Close resources in reverse order of creation
      if (resultSet != null) resultSet.close()
      if (statement != null) statement.close()
      if (connection != null) connection.close()
    }
  }
}
