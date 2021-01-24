package net.subroh0508.kmmsample.shared.infra.repository

import net.subroh0508.kmmsample.shared.infra.api.ImasparqlClient
import net.subroh0508.kmmsample.shared.infra.api.internal.HOSTNAME
import net.subroh0508.kmmsample.shared.infra.api.internal.ImasparqlApiClient
import net.subroh0508.kmmsample.shared.infra.api.internal.httpClient
import net.subroh0508.kmmsample.shared.infra.api.json.IdolJson
import net.subroh0508.kmmsample.shared.model.Idol

class IdolsRepository(
    private val client: ImasparqlClient = ImasparqlApiClient(httpClient),
) {
    suspend fun search(query: String?) = client.execute(
        buildQuery(query),
        IdolJson.serializer(),
    ).results.bindings.mapNotNull { it.toEntity() }

    private fun buildQuery(queryStr: String?) = buildString {
        append("$ENDPOINT_MAIN?output=json&query=")
        append("""
            PREFIX schema: <http://schema.org/>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX imas: <https://sparql.crssnky.xyz/imasrdf/URIs/imas-schema.ttl#>
            PREFIX foaf:  <http://xmlns.com/foaf/0.1/>

            SELECT *
            WHERE {
              ?s a imas:Idol;
                schema:name ?name;
                imas:Title ?title;   
                imas:Color ?color;
                foaf:age ?age;
                schema:birthPlace ?birthplace;
                imas:Hobby ?hobby;
                imas:IdolListURL ?idollistUrl.   
              FILTER (lang(?name) = 'ja')
              FILTER (str(?title) != '1st Vision')
              ${queryStr?.let {"FILTER (regex(?name, '.*$it.*', 'i') || regex(?yomi, '.*$it.*', 'i'))." } ?: ""}
              OPTIONAL { ?s imas:alternateNameKana ?tmp }
              OPTIONAL { ?s imas:nameKana ?tmp }
              OPTIONAL { ?s imas:givenNameKana ?tmp }
              BIND(?tmp AS ?yomi)
              BIND (REPLACE(str(?s), '${ESCAPED_ENDPOINT_RDFS_DETAIL}', '') as ?id)
            }
            ORDER BY ?yomi
        """.trimIndentAndBr())
    }

    private fun String.trimIndentAndBr() = trimIndent().replace("[\n\r]", "")

    private fun IdolJson.toEntity() = let { json ->
        val id = json.id["value"] ?: return@let null
        val name = json.name["value"] ?: return@let null
        val yomi = json.yomi["value"] ?: return@let null
        val color = json.color["value"] ?: return@let null
        val age = json.age["value"] ?: return@let null
        val birthplace = json.birthplace["value"] ?: return@let null
        val hobby = json.hobbies["value"] ?: return@let null
        val idollistUrl = json.idollistUrl["value"] ?: return@let null

        Idol(id, name, yomi, "#$color", age.toInt(), birthplace, listOf(hobby), idollistUrl)
    }

    companion object {
        private const val ENDPOINT_MAIN = "/spql/imas/query"
        private const val ESCAPED_ENDPOINT_RDFS_DETAIL = """https://$HOSTNAME/imasrdf/RDFs/detail/"""
    }
}
