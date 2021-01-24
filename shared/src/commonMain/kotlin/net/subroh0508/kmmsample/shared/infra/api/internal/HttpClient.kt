package net.subroh0508.kmmsample.shared.infra.api.internal

import io.ktor.client.HttpClient

internal expect val httpClient: HttpClient

internal const val HOSTNAME = "sparql.crssnky.xyz"
