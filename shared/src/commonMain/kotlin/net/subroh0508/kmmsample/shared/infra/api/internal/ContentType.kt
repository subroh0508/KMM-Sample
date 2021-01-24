package net.subroh0508.kmmsample.shared.infra.api.internal

import io.ktor.http.ContentType as KtorContentType

abstract class ContentType {
    object Application {
        val SparqlJson = KtorContentType("application", "sparql-results+json")
    }
}
