import org.apache.commons.net.smtp.AuthenticatingSMTPClient
import org.apache.commons.net.smtp.SimpleSMTPHeader
import org.junit.jupiter.api.Test
import java.net.InetSocketAddress
import java.net.Socket

class SMTP {


    @Test
    fun grand (){
        val a = Socket()
        a.connect(InetSocketAddress("smtp.gmail.com" , 587))
    }
    @Test
    fun apacheTLSTest (){
        val a = "etiennept@gmail.com"
        val c = "smtp.gmail.com"


        AuthenticatingSMTPClient(   ).apply {
            try {
                connect(c ,587)
                ehlo(c )
                execTLS()
                auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN , "etiennept" , "kexctucaccedbgxn"  )

                setSender(a)
                addRecipient(a )
                sendMessageData()?.use {
                    it.write("""
                        From : etiennept@gmail.com 
                        To : etiennept@gmail.com 
                        Subject : Test
                        MIME-Version: 1.0 
                        Content-Type :  text/plain 
                        
                         eeeeeee""".trimIndent())
                } ?: throw Exception(" $replyString")
                println(this.completePendingCommand() )
                println(replyString)

            }finally {

                disconnect()
            }
        }



    }
    @Test
    fun apacheSSLTest(){
        val a = "etiennept@gmail.com"
        val c = "smtp.gmail.com"
        AuthenticatingSMTPClient("SSL", true ).apply {
            try {
                connect(c , 465)
                ehlo(c)
                auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN , "etiennept"  , "kexctucaccedbgxn")
                setSender(a)
                addRecipient(a )
                sendMessageData()?.use {
                    it.write("eeeeeee")
                } ?: throw Exception(replyString)
                println(this.completePendingCommand() )
                println(replyString)
            } finally {
                disconnect()
            }
        }
    }

    @Test
    fun parser () {
        val a = Regex("From: ([a-zA-Z0-9<>()]+\n)+").find("From: eee\neeee\nTo: eee ")!!.value
        println(a)

    }
}