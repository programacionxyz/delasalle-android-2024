
// Extension functions
// They are used to add functionality to classes that we do not own.

// EXAMPLE 1. Write a function to remove multiple white Spaces in a string
fun removeMultipleWhiteSpaces2(text:String):String{
    val regex = Regex("\\s+")
    return regex.replace(text," ")
}

fun String.removeMultipleWhiteSpaces():String{
    val regex = Regex("\\s+")
    return regex.replace(this," ")
}

fun main(){
    val text = "My Text   with   white     Spaces"
    println(text)
    println(removeMultipleWhiteSpaces2(text))
    println(text.removeMultipleWhiteSpaces())
}