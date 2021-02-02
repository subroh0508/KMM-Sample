package net.subroh0508.kmmsample.shared.data.infra.repository.di

import net.subroh0508.kmmsample.shared.data.infra.repository.IdolsRepository
import net.subroh0508.kmmsample.shared.data.infra.repository.internal.IdolsRepositoryImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

object IdolRepositories {
    private const val NAME = "IDOL_REPOSITORIES_MODULE"

    val Module get() = DI.Module(NAME)  {
        bind<IdolsRepository>() with singleton { IdolsRepositoryImpl(instance()) }
    }
}
