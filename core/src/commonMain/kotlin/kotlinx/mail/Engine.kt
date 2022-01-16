package kotlinx.mail

import kotlinx.mail.imap.IMAPClient
import kotlinx.mail.pop3.POP3Client
import kotlinx.mail.smpt.SMTPClient

abstract class Engine  {
    abstract fun createSMTPClient (  )  : SMTPClient
    abstract fun createIMAPClient () : IMAPClient
    abstract fun createPOP3Client () : POP3Client
}