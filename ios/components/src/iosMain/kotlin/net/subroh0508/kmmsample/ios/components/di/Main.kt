package net.subroh0508.kmmsample.ios.components.di

import net.subroh0508.kmmsample.shared.api.di.Api
import net.subroh0508.kmmsample.shared.data.infra.repository.di.IdolsRepositories
import net.subroh0508.kmmsample.shared.presentation.IdolsViewModel
import net.subroh0508.kmmsample.shared.presentation.di.IdolsViewModelDI
import org.kodein.di.*
import kotlin.native.concurrent.ensureNeverFrozen

object Main {
    private val DI get() = IdolsViewModelDI(Api.Module(), IdolsRepositories.Module).apply {
        container.tree.bindings.ensureNeverFrozen()
    }

    fun createIdolsViewModel(): IdolsViewModel = DI.di.direct.instance<IdolsViewModel.Factory>().create()
}
