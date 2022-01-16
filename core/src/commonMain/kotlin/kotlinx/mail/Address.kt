package kotlinx.mail

data class Address(var emailAddress: String, var name : String  ){

    override fun toString(): String = if (name =="" )
        "<$emailAddress>" else "$name <$emailAddress>"
}