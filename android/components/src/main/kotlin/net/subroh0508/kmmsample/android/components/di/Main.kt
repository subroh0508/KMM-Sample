package net.subroh0508.kmmsample.android.components.di

import net.subroh0508.kmmsample.shared.api.di.Api
import net.subroh0508.kmmsample.shared.data.infra.repository.di.IdolsRepositories
import org.kodein.di.DI

object Main {
    private const val NAME = "MAIN_MODULE"

    val Module = DI.Module(NAME) {
        importOnce(Api.Module())
        importOnce(IdolsRepositories.Module)
    }
}
