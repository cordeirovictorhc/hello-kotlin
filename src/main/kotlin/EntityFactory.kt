import java.util.*

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

enum class EntityType {
    HELP, EASY, MEDIUM, HARD;

    fun getPrettyName() = name.lowercase().capitalize() // deprecated but still works - jan/2022
}

object EntityFactory {
    fun create(type: EntityType): /* OtherEntity */ OneMoreEntity {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            EntityType.EASY -> type.name // match the exact name of the class -> EASY
            EntityType.MEDIUM -> type.getPrettyName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getPrettyName()
        }
        // return OtherEntity(id, name)

        return when(type) {
            EntityType.EASY -> OneMoreEntity.Easy(id, name)
            EntityType.MEDIUM -> OneMoreEntity.Medium(id, name)
            EntityType.HARD -> OneMoreEntity.Hard(id, name, 2f)
            EntityType.HELP -> OneMoreEntity.Help
        }
    }
}

class OtherEntity(val id: String, val name: String) {
    override fun toString(): String {
        return "id: $id name: $name"
    }
}

// sealed -> can't directly instantiate sealed classes
sealed class OneMoreEntity() {
    object Help : OneMoreEntity() {
        val name = "Help"
    }

    data class Easy(val id: String, val name: String): OneMoreEntity() {
        override fun equals(other: Any?): Boolean {
            return super.equals(other)
        }

        override fun hashCode(): Int {
            return super.hashCode()
        }
    }
    data class Medium(val id: String, val name: String): OneMoreEntity()
    data class Hard(val id: String, val name: String, val multiplier: Float): OneMoreEntity()
}

fun OneMoreEntity.Medium.outFunction(): String { // extension method
    return "I got created outside"
}

val OneMoreEntity.Medium.outProperty: String // extension property
    get() = "I also got created outside"

fun main() {
    // val entity = Entity() -> error; private constructor
    // val entity = Entity.Companion.create()
    val entity = Entity.create() // in Kotlin, we can omit Companion
    println(entity.id)

    val easyEntity = EntityFactory.create(EntityType.EASY)
    val mediumEntity = EntityFactory.create(EntityType.MEDIUM)
    val hardEntity = EntityFactory.create(EntityType.HARD)
    println(easyEntity)
    println(mediumEntity)
    println(hardEntity)

    val message = when(EntityFactory.create(EntityType.HELP)) {
        OneMoreEntity.Help -> "Help Class"
        is OneMoreEntity.Easy -> "Easy Class"
        is OneMoreEntity.Medium -> "Medium Class"
        is OneMoreEntity.Hard -> "Hard Class"

    }
    println(message)

    // val entity1 = EntityFactory.create(EntityType.EASY)
    // val entity2 = EntityFactory.create(EntityType.EASY)
    val entity1 = OneMoreEntity.Medium("id","name")
    // var entity2 = OneMoreEntity.Medium("id","name")
    val entity2 = entity1.copy(name = "Victor") // copy() is accessible because this is a data class

    // === -> check is reference is the same; exact same object
    // == -> other object that has same data
    if (entity1 == entity2) {
        println("they are equal")
    } else {
        println("they are not equal")
    }

    println(entity1.outFunction())
    println(entity1.outProperty)
}