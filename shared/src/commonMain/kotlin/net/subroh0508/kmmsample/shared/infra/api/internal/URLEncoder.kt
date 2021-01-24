package net.subroh0508.kmmsample.shared.infra.api.internal

internal expect object URLEncoder {
    fun encode(s: String): String
}
