// EXAMPLE 1. Function Declarations
fun sayHello(){
    println("Hello World")
}
// EXAMPLE 2. Default arguments and named arguments
fun sayHello2(name:String){
    println("Hello $name")
}
fun greet(name:String = "Emiliano",greeting:String = "Hello"){
    println("$greeting, $name")
}

// EXAMPLE 3. Return Types
fun add(a:Int, b:Int):Int{
    return a + b
}
// EXAMPLE 4. Single-expression functions
fun multiply(a:Int, b:Int):Int = a * b

fun main() {
    sayHello()
    sayHello2("John")
    greet()
    greet(greeting = "Bye",name ="Jhon")

    val result = multiply(2,3)
    println(result)
}





