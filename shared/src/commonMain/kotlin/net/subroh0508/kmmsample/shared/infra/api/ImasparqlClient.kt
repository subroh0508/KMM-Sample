package net.subroh0508.kmmsample.shared.infra.api

import kotlinx.serialization.KSerializer
import net.subroh0508.kmmsample.shared.infra.api.serializer.SparqlResponse

interface ImasparqlClient {
    suspend fun <T> execute(
        query: String,
        serializer: KSerializer<T>
    ): SparqlResponse<T>
}
