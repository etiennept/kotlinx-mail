package kotlinx.mail

import kotlin.time.Duration

data class EMail(var from : String,
                 var to : List<String>,
                 var cc : List<String>,
                 var Date : Date,
                 var subject : String,
                 val body : String,
                 ){

    override fun toString(): String  =
        "From: $from\r\n" +
                "To: ${to.ee()}\r\n" +
                "Cc: ${cc.ee()}\r\n" +
                "Date: $Date" +
                "Subject: $subject\r\n" +
                ""+
                ""


    private fun List<String>.ee(): String {
        var a = ""
         if (isNotEmpty()) {
            for ( i in 0 until size -1){
                a+= "${get(i)}, "
            }
            a+=get(size-1)
         }
        return a
    }


}


