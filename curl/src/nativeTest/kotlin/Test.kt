import kotlinx.cinterop.*
import libcurl.*
import libcurl. curl_usessl.*
import platform.posix.*
import kotlin.test.Test



class Text(val string: String)


fun CPointer<*>.option(option: CURLoption, value: Long) = curl_easy_setopt(this, option, value).verify()
fun CPointer<*>.option(option: CURLoption, value: CPointer<*>) = curl_easy_setopt(this, option, value).verify()
fun CPointer<*>.option(option: CURLoption, value: String) = curl_easy_setopt(this, option, value).verify()


fun CURLcode.verify() {
    if (this != CURLE_OK) {
        throw Exception(curl_easy_strerror(this)!!.toKString())
    }
}

fun CPointer<*>.perform () = curl_easy_perform(this ).verify()


fun CValuesRef<curl_slist>?.append(string: String) = curl_slist_append(this, string)!!

