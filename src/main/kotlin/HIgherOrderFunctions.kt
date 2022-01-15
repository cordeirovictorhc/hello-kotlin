// higher order function -> either return another function or take functions as params
fun printFilteredStrings(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
        /*
        if (predicate(it)) {
            println(it)
        }
        */

        // predicate is nullable -> safe invoke call
        if (predicate?.invoke(it) == true) {
            println(it)
        }
    }
}

val predicate: (String) -> Boolean = {
    it.startsWith("K")
}

fun getPrintPredicate(): (String) -> Boolean {
    return { it.startsWith("C") }
}

fun main(   ) {
    val list = listOf<String>("Java", "Kotlin", "JavaScript", "C++")
    // printFilteredStrings(list, { it.startsWith("K") }) // return only words that start with ...
    printFilteredStrings(list) { it.startsWith("J") } // since last param is a fun, we can place it outside ()
    printFilteredStrings(list, null)
    printFilteredStrings(list, predicate)
    printFilteredStrings(list, getPrintPredicate())
}