fun main() {

    // EXAMPLE 1
    val x = 10
    val y = 11

    if(x >= y){
        println("$x >= $x")
    }
    else{
        println("$y > $x")
    }

    // EXAMPLE 2 . If as an expression
    var result = if(x >= y) "$x >= $y" else "$y > $x"
    println(result)

}