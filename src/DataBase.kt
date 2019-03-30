import java.sql.*
import java.util.*

class DataBase (val username: String,val password: String,val dataBase: String) {

    var connection:Connection? = null

    init {
        connection = createConnection(username,password)
        if(connection != null){
            println("Succesfull Connection!")
        }
    }


    private fun createConnection(username:String,password:String) : Connection?{
        val connectionProps = Properties()
        connectionProps.put("user", username)
        connectionProps.put("password", password)
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/$dataBase", connectionProps)
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
        return null
    }


    fun showTablesInDataBase(){
        var stmt: Statement? = null
        var resultset: ResultSet? = null

        try {
            stmt = connection!!.createStatement() // A conn-ból lekérdezést kérünk
            resultset = stmt!!.executeQuery("SHOW TABLES;") //

            if (stmt.execute("SHOW TABLES;")) {
                resultset = stmt.resultSet
            }

            while (resultset!!.next()) {
                println(resultset.getString("Tables_in_$dataBase"))
            }
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        }
    }

}