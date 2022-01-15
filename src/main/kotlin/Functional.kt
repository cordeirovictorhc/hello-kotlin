fun main() {
    val list = listOf("Kotlin", "Java", "C++", null, "JavaScript", null, "Python", "OCaml", null)

    list.filterNotNull()
        .filter {
            it.startsWith("J")
        }
        .map {
            it.length
        }
        .forEach {
            println(it)
        }

    list.filterNotNull()
        .take(3) // take the first 3 items
        .takeLast(2) // take the last 2 items
        .forEach {
            println(it)
        }

    val map = list.filterNotNull()
        .associateWith { it.length } // it = key, to = value -> return {key=value, ...}

    println(map)

    // val language = list.first()
    // val language = list.filterNotNull().last()
    val language = list.filterNotNull().find { it.startsWith("foo") }.orEmpty()
    println(language)
}