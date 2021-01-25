package net.subroh0508.kmmsample.shared.api.internal

import java.net.URLEncoder as JavaURLEncoder

/*internal*/ actual object URLEncoder {
    actual fun encode(s: String): String = JavaURLEncoder.encode(s, "UTF-8")
}
