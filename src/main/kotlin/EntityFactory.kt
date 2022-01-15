interface IdProvider {
    fun getId(): String
}

class Entity private constructor(val id: String) {
    companion object Factory: IdProvider {
        override fun getId(): String {
            return "2503"
        }

        // const val id = "2503"

        fun create() = Entity(getId())
    }
}

object EntityFactory {
    fun create() = OtherEntity("1808", "Octávio")
}

class OtherEntity(val id: String, val name: String) {
    override fun toString(): String {
        return "id: $id name: $name"
    }
}

fun main() {
    // val entity = Entity() -> error; private constructor
    // val entity = Entity.Companion.create()
    val entity = Entity.create() // in Kotlin, we can omit Companion
    println(entity.id)

    val otherEntity = EntityFactory.create()
    println(otherEntity)
}