package kotlinx.mail.smpt

import kotlinx.mail.EMail

abstract class SMTPClient {

    abstract fun send( eMail: EMail  )
}