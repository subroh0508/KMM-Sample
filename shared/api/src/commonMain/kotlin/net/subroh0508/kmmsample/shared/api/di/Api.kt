package net.subroh0508.kmmsample.shared.api.di

import io.ktor.client.*
import net.subroh0508.kmmsample.shared.api.ImasparqlClient
import net.subroh0508.kmmsample.shared.api.internal.ImasparqlApiClient
import net.subroh0508.kmmsample.shared.api.internal.httpClient
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

object Api {
    private const val NAME = "API_MODULE"

    @Suppress("FunctionName")
    fun Module(client: HttpClient = httpClient) = DI.Module(NAME) {
        bind<HttpClient>() with singleton { client }
        bind<ImasparqlClient>() with singleton { ImasparqlApiClient(instance()) }
    }
}
