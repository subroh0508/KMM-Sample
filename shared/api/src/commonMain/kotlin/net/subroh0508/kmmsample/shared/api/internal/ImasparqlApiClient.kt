package net.subroh0508.kmmsample.shared.api.internal

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.*
import io.ktor.utils.io.charsets.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import net.subroh0508.kmmsample.shared.api.ImasparqlClient
import net.subroh0508.kmmsample.shared.api.serializer.SparqlResponse

/*internal*/ class ImasparqlApiClient(
    private val httpClient: HttpClient
) : ImasparqlClient {
    override suspend fun <T> execute(
        query: String,
        serializer: KSerializer<T>,
    ): SparqlResponse<T> {
        val response = httpClient.get<HttpResponse>(query)

        return Json {
            isLenient = true
            ignoreUnknownKeys = true
            allowSpecialFloatingPointValues = true
            useArrayPolymorphism = true
        }.decodeFromString(
            SparqlResponse.serializer(serializer),
            response.readText(Charset.forName("UTF-8"))
        )
    }
}
