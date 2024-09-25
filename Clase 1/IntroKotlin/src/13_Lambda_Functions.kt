// A lambda is an anonymous function, meaning a function that does not have an associated name.
// { parameters -> body }

// EXAMPLE 1. Lambda definition
val sum = { x: Int, y: Int -> x + y }
val extractFirstLetter = {s:String -> s[0]}

// EXAMPLE 2. One string
fun main() {
    val result = sum(1,2)
    val result2 = extractFirstLetter("My Name is")
}