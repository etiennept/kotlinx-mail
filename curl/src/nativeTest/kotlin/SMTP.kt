import kotlinx.cinterop.*
import libcurl.*
import platform.posix.memcpy
import kotlin.test.Test

class SMTP {
    /* @Test
     fun curlSSLTest(){
         val easy = curl_easy_init()!!
         var rect = null as CPointer<curl_slist>?
         try {
             easy.run {
                 option(CURLOPT_USERNAME , "etiennept")
                 option(CURLOPT_PASSWORD , "kexctucaccedbgxn")
                 option(CURLOPT_URL ,"smtps://smtp.gmail.com")
                 option(CURLOPT_MAIL_FROM  , "etiennept@gmail.com" )
                 rect = rect.append("etiennept@gmail.com")
                 option(CURLOPT_MAIL_RCPT , rect!! )
                 option(CURLOPT_READFUNCTION , staticCFunction{  byte : CPointer<ByteVar>, a: ULong, b:ULong, pointer: CPointer<*> ->
                     pointer.asStableRef<(CPointer<ByteVar> , ULong , ULong   ) -> ULong >().get()(byte ,a , b )
                 })
                 val x = "eeeeeeeeeeee\neeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
                 var i = true
                 option(CURLOPT_READDATA , StableRef.create { byte: CPointer<ByteVar>, a: ULong, b: ULong , pointer: CPointer<*> ->
                     memcpy(byte,  memScoped {
                        allocArray<ByteVar>(x.length ) .apply {
                            for ( i in x.indices){
                                set(i , x[i].code.toByte())
                            }
                        } } ,  x.length.toULong()   )

                    if (i ){
                        i = false
                        x.length
                    }else{
                        0
                    }





                 }.asCPointer())
                 option(CURLOPT_UPLOAD, 1L)
                 //option(CURLOPT_VERBOSE , 1L )
                 perform()
             }
         }finally {
             curl_slist_free_all(rect)
             curl_easy_cleanup(easy)
         }

     }*/
    @Test
    fun curlTLSTest (){
        val easy = curl_easy_init()!!
        var rect = null as CPointer<curl_slist>?
        try {
            easy.run {
                option(CURLOPT_USERNAME , "etiennept")
                option(CURLOPT_PASSWORD , "kexctucaccedbgxn")
                option(CURLOPT_URL ,"smtp://smtp.gmail.com:587")
                option(CURLOPT_USE_SSL , curl_usessl.CURLUSESSL_ALL.value.toLong())
                option(CURLOPT_MAIL_FROM  , "etiennept@gmail.com" )
                rect = rect.append("etiennept@gmail.com")

                option(CURLOPT_MAIL_RCPT , rect!! )
                option(CURLOPT_READFUNCTION , staticCFunction{ byte : CPointer<ByteVar>, a: ULong, b:ULong, pointer: CPointer<*> ->
                    pointer.asStableRef<(CPointer<ByteVar>, ULong, ULong   ) -> ULong >().get()(byte ,a , b )
                })

                val x = "eeeeeeeeeeeeeeeeeee  \n eeeeeeeeeee"
                var i = true
                option(CURLOPT_READDATA , StableRef.create { byte: CPointer<ByteVar>, a: ULong, b: ULong, pointer: CPointer<*> ->

                    memcpy(byte,  memScoped {
                        allocArray<ByteVar>(x.length ) .apply {
                            for ( i in x.indices){
                                set(i , x[i].code.toByte())
                            }
                        } } ,  x.length.toULong())

                    if (i ){
                        i = false
                        x.length
                    }else{
                        0
                    }


                }.asCPointer())
                option(CURLOPT_UPLOAD, 1L)

                //option(CURLOPT_VERBOSE , 1L )
                perform()
            }
        }finally {
            curl_slist_free_all(rect)
            curl_easy_cleanup(easy)
        }


    }


}