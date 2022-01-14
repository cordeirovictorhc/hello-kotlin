/*

class Person(_name: String, _age: Int) {
    val name: String = _name
    val age: Int = _age

    init {
        // get executed every new instance
    }
}

*/

// internal -> public within the module
// private -> only available in the file which is implemented
class Person(val name: String = "Victor", val age: Int = 25) {
    // internal, private...
    // protected -> only available in this class or its subclasses
    var nickname: String? = null
        /*

        get() {
            // println("the returned value is $field")
            return field
        }
        set(value) {
            field = value
            // println("new nickname is $value")
        }

        */

    fun printInfo(): Unit {
        println("name: $name${ if (nickname != null) " ($nickname)" else "" }, age: $age")
        // println("name: $name (${ nickname?: "None"}), age: $age")
    }
}