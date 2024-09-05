abstract class MyAbstract {
    var firstName = ""
    var lastName = ""
    var address = ""

    open fun getFullName() = "$firstName $lastName"
    abstract fun getMyAddress(): String
}


fun main() {
    // val myObject = MyClass()
    // println(myObject.getFullName())
}