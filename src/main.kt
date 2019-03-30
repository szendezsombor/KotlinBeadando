val username:String = "root"
val password:String = ""
val dataBase:String = "storagesystemdatabase"
val mainDataBase = DataBase(username,password,dataBase)

fun main() {
    println("Aviable Databases")
    mainDataBase.showTablesInDataBase()

}