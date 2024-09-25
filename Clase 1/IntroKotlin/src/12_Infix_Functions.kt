// Have a single parameter
// Infix keyword
// It gives us the ability to use functions as if they were arithmetic operators.


class Label(var content: String)

fun main() {

    // Example 1 : Pair<A,B>
    var pair1 = 1.to("one")
    var pair2 = 2.to("two")
    var pair3 = 3 to "three"

    println(pair1)
    println(pair2)

    // Example 2 : Until
    for (i in 1.until(10)) {
        println(i)
    }

    for (i in 1 until 10 step 2 ) {
        println(i)
    }
    // Custom Example 1

    val myText = "Hello World this is my text"
    val result = myText remove "Hello World"
    // val result2 = myText.remove("")
    // println(result)
    // Custom Example 2
}

infix fun String.remove(text:String):String{
    return this.replace(text, "")
}