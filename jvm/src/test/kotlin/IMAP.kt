import org.apache.commons.net.imap.IMAPSClient
import org.junit.jupiter.api.Test


class IMAP {
    @Test
    fun  apacheSSLTest  (){
        IMAPSClient("SSL", true).apply {
            try {
                connect("imap.gmail.com" , 993)
                if(!login("etiennept@gmail.com" , "kexctucaccedbgxn") ){
                    throw Exception(replyString)
                }

                //addProtocolCommandListener(PrintCommandListener(System.out , true ))
                //capability();

                if ( !select("INBOX") ){
                    throw Exception(replyString)
                }


                list("", "*");
                println(replyString)


            }finally {
                logout()
                disconnect()
            }

        }

    }


}