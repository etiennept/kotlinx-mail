import org.apache.commons.net.pop3.POP3SClient
import org.junit.jupiter.api.Test

class POP3 {

    @Test
    fun sslTest (){
        POP3SClient( "SSL" , true ).apply {
            try {
                connect("pop.gmail.com" ,995)
                this.login("etiennept" ,"kexctucaccedbgxn")

                this.listMessages()

            }finally {
                logout()
                disconnect()
            }
        }
    }

}