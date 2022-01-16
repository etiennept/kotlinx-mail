package kotlinx.mail

enum class MIMEHeader {
    MIMEVersion { override fun toString() ="MIME-Version" } ,
    ContentID { override fun toString() ="Content-ID" },
    ContentDescription { override fun toString() ="Content-Description" } ,
    ContentTransferEncoding{ override fun toString() ="Content-Transfer-Encoding" },
    ContentType{ override fun toString() ="Content-Type" },
    ContentBase { override fun toString() ="Content-Base" },
    ContentLocation{ override fun toString() ="Content-Location" },
    ContentFeatures{ override fun toString() ="Content-features" },
    ContentDisposition{ override fun toString() ="Content-Disposition" } ,
    ContentLanguage{ override fun toString() ="Content-Language" } ,
    ContentAlternative{ override fun toString() ="Content-Alternative" } ,
    ContentDuration{ override fun toString() ="Content-Duration" }

}