
// Class Definition
class Person {
    var name: String = ""
}

// Constructor
open class Human(var name:String = ""){
}

class Human2:Human(){

}

fun main() {

    // EXAMPLE 1. Instance of a person
    var person = Person()
    person.name = "Emiliano"
    println("Your name is ${person.name}") // String Templates
    person = Person()

    // EXAMPLE 2. Instance of a person
    val person2 = Person()
    person2.name = "asdf"
    person2.name = "adsfasdf"

    // person2 = Person() // ERROR
    //ERROR
    // student = Person()
    //EXAMPLE 3
    var human = Human("Emiliano")
    println(human.name)

}