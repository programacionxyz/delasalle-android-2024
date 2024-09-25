fun main() {

    val value = 10

    // EXAMPLE 1. There is not switch in Kotlin
    when (value) {
        15 -> println("Number is 15")
        12 -> println("Number is 12")
        10 -> println("Number is 10")
        else -> println("??")
    }

    // EXAMPLE 2. "when" can be used as expression
    val numberToDisplay = when (value) {
        2-> "Value is equal to 2"
        else -> "it is another value "
    }
    val x = 110
    // EXAMPLE 3. "when" is more flexible than switch
    when(x)
    {
        1-> println("Number is 1")
        0,2 -> println("x 0 or 2")
        in 1..10 -> println("Number is in 1..10")
        else ->{
            println("Nothing to do ")
        }
    }

}