data class Developer(var name: String, var age: Int, var city: String)

fun main() {

    // Scope Functions in Kotlin are special functions that allow you to execute a block of code within the context of an object.
    // They are very useful for improving code readability, avoiding repetition, and working with an
    // object temporarily within a limited scope. The most common scope functions in Kotlin are:

    // let: Ideal for working with non-null or temporary objects. It uses it.
    val dev1 = Developer("John", 30, "New York")


    // run: Allows executing operations and returning the result. It uses this.
    val dev2 = Developer("Emily", 27, "Boston")

    // with: Executes multiple operations on an existing object. It uses this.
    val dev3 = Developer("Alice", 25, "Chicago")


    // apply: Configures an object and returns the object itself. It uses this
    val dev4 = Developer("Bob", 35, "Miami")

    // also: Performs secondary actions and returns the object. It uses it
    val dev5 = Developer("Carol", 29, "Seattle")

}