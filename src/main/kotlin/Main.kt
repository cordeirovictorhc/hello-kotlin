// no return type -> unit
fun greeting(person: String): Unit {
    println("Hello, $person")
}

fun visited(something: String = "I've been to", vararg countries: String = arrayOf()) {
    countries.forEach { country -> println("$something $country") }
}

fun main(args: Array<String>) {
    // mutable variables -> var <variable_name>: <type> = <initializer>
    // read only variables; constants -> val <variable_name>: <type> = <initializer>
    // nullable strings -> var <variable_name>: String? = null

    var name: String? = null
    name = "Victor"

    if (name != null) greeting(name)

    val isPirralho = if (name == "Octávio") true else false // also works for WHEN
    println("isPirralho: $isPirralho")

    // switch case
    when(name) {
        null -> println("null case")
        "Victor" -> println("isNotOctávio")
        "Octávio" -> println("isNotVictor")
        else -> println("default case") // default
    }

    // val movies = arrayOf("Harry Pother", "Deadpool", "Lord of the Rings") -> immutable array
    var movies = mutableListOf("Logan", "Maze Runner", "Deadpool")
    movies.add("Divergent")
    println("array: $movies")
    println("size: " + movies.size)
    println("first item: " + movies[0])
    println("last item: " + movies.get(movies.size - 1))

    for (m in movies) {
        print("$m ")
    }
    print("\n")

    /*
    movies.forEach {
        println("$it")
    }
    */
    
    movies.forEachIndexed { index, s -> println("$index: $s,") }

    val map = mapOf("foo" to "bar", 1 to "Atlético MG", 3 to "Cruzeiro")
    println("similar to js object: $map")

    map.forEach { (key, value) -> println("$key: $value") }

    // the above also works for LISTOF

    val countries = arrayOf("Belgium", "Germany", "Hungary", "Netherlands")
    visited("I miss", *countries) // spread operator, allow array as param
}