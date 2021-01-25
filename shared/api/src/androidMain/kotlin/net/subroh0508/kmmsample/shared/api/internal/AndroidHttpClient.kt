package net.subroh0508.kmmsample.shared.api.internal

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.URLProtocol
import net.subroh0508.kmmsample.shared.api.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor
import kotlinx.serialization.json.Json as SerializationJson

/*internal*/ actual val httpClient get() = HttpClient(OkHttp) {
    engine {
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(loggingInterceptor)
        }

        // @see https://github.com/ktorio/ktor/issues/1708
        config {
            retryOnConnectionFailure(true)
        }
    }
    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = HOSTNAME
        }
        accept(ContentType.Application.SparqlJson)
    }
    Json {
        acceptContentTypes = listOf(ContentType.Application.SparqlJson)
        serializer = KotlinxSerializer(SerializationJson {
            isLenient = true
            ignoreUnknownKeys = true
            allowSpecialFloatingPointValues = true
            useArrayPolymorphism = true
        })
    }
}
