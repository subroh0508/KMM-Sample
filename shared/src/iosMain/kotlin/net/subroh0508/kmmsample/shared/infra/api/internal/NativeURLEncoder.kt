package net.subroh0508.kmmsample.shared.infra.api.internal

import platform.Foundation.NSCharacterSet
import platform.Foundation.NSString
import platform.Foundation.URLHostAllowedCharacterSet
import platform.Foundation.stringByAddingPercentEncodingWithAllowedCharacters

@Suppress("CAST_NEVER_SUCCEEDS")
internal actual object URLEncoder {
    actual fun encode(s: String): String =
        (s as NSString).stringByAddingPercentEncodingWithAllowedCharacters(NSCharacterSet.URLHostAllowedCharacterSet()) ?: ""
}
