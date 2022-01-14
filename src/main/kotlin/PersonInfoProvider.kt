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

// basicInfoProvider implements PersonInfoProvider
// abstract -> doesn't need to implement all included interfaces available methods, it cannot be instantiated
class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "BasicInfoProvider"

    override fun printInfo(person: Person) {
        // super.printInfo(person)
        println("override")
    }

    override fun getSessionId(): String {
        return "Session ID"
    }
}

fun main() {
    val provider = BasicInfoProvider()
    provider.printInfo(Person())
    println(provider.getSessionId())
}

fun checkTypes(infoProvider: PersonInfoProvider) {
    if (infoProvider !is SessionInfoProvider) {
        println("is not a session info provider")
    } else {
        println("is a session info provider")
        // (infoProvider as SessionInfoProvider).getSessionId()
        infoProvider.getSessionId() // implicit casting, since we have already verified type with if conditional
    }

}