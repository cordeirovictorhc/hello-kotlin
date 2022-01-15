import java.util.*

class FancyInfoProvider : BasicInfoProvider() {
    override val providerInfo: String
        get() = "FancyInfoProvider"

    override val sessionIdPrefix: String
        get() = "${super.sessionIdPrefix}: ${UUID.randomUUID()}"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("fancy additional info")
    }
}