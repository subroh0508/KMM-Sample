package net.subroh0508.kmmsample.shared.data.infra.repository

import net.subroh0508.kmmsample.shared.data.model.Idol
import net.subroh0508.kmmsample.shared.api.ImasparqlClient
import net.subroh0508.kmmsample.shared.api.internal.HOSTNAME
import net.subroh0508.kmmsample.shared.api.internal.ImasparqlApiClient
import net.subroh0508.kmmsample.shared.api.internal.URLEncoder
import net.subroh0508.kmmsample.shared.api.internal.httpClient
import net.subroh0508.kmmsample.shared.api.json.IdolJson

interface IdolsRepository {
    suspend fun search(query: String?): List<Idol>
}
