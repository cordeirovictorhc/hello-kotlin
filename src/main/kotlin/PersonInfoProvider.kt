/*

interface PersonInfoProvider {
    fun printInfo(person: Person)
}

*/

interface PersonInfoProvider {
    val providerInfo: String

    fun printInfo(person: Person) { // set default implementation
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider {
    fun getSessionId() : String
}

// basicInfoProvider implements PersonInfoProvider and SessionInfoProvider
// abstract -> doesn't need to implement all included interfaces available methods, it cannot be instantiated
// final -> it can not be inherited from
open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "BasicInfoProvider"

    override fun printInfo(person: Person) {
        // super.printInfo(person)
        println("override")
    }

    // protected open -> works for inheritance, but it is not public
    protected open val sessionIdPrefix = "Session"

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}

fun main() {
    val provider = FancyInfoProvider()
    provider.printInfo(Person())
    // println(provider.getSessionId())
    checkTypes((provider))

    // object expression -> kind of anonymous class
    val objectExpression = object : PersonInfoProvider {
        override val providerInfo: String
            get() = "New Info Provider"

        fun getSessionId() = "id"
    }

    objectExpression.printInfo(Person())
    objectExpression.getSessionId()
}

fun checkTypes(infoProvider: PersonInfoProvider) {
    if (infoProvider !is SessionInfoProvider) {
        println("is not a session info provider")
    } else {
        println("is a session info provider")
        // (infoProvider as SessionInfoProvider).getSessionId()
        println(infoProvider.getSessionId()) // implicit casting, since we have already verified type with if conditional
    }

}