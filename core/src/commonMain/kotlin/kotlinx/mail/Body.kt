package kotlinx.mail

abstract class  Body<T>(){
    abstract var value :T
}
data class StringBody(override var value : String):  Body<String> () {
    override fun toString() = value
}

abstract class Mine
data class MIMEBody(override var value: Mine) :Body<Mine>(){



}
