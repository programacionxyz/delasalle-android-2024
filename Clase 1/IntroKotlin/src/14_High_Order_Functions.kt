// 1) Receive functions as parameters: They can take functions as arguments.
// 2) Return functions: They can return a function as a result.
// 3) Conciseness: They allow writing more concise code, especially when working with repetitive
//    operations or dynamic actions.

// EXAMPLE 1. Receive function as a parameter

fun operateOnTwoNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// EXAMPLE 2. Receives a function as a parameter, and the function receives one parameter only

fun multiply2(a: Int, b: Int): Int {
    return a * b
}

fun makeMultiplier(a:Int, funMultiplier:(Int) ->Int):Int{
    return a * funMultiplier(1)
}

fun main() {
    val sum = { x: Int, y: Int -> x + y }
    val result = operateOnTwoNumbers(5, 3, sum)
    val result2 = operateOnTwoNumbers(5, 3,::multiply2)
    val result3 = operateOnTwoNumbers(5, 3){x, y -> x*y}
    val result4 = makeMultiplier(5){
        it * 2
    }

    println(result)
    println(result2)

    // EXAMPLE 4.  Standard High Order functions already implemented in Kotlin

}


