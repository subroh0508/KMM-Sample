package net.subroh0508.kmmsample.shared.infra.api.serializer

import kotlinx.serialization.Serializable

@Serializable
data class SparqlResponse<out T>(
    val head: Vars,
    @Serializable(with = ResultsSerializer::class)
    val results: Results<T>
) {
    @Serializable
    data class Vars(
        val vars: List<String>
    )

    data class Results<out T>(
        val bindings: List<T>
    )
}
