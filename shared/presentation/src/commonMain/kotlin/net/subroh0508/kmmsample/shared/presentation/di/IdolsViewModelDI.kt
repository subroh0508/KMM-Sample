package net.subroh0508.kmmsample.shared.presentation.di

import net.subroh0508.kmmsample.shared.presentation.IdolsViewModel
import org.kodein.di.*

@Suppress("FunctionName")
inline fun IdolsViewModelDI(
    vararg module: DI.Module,
) = DI {
    module.forEach { import(it) }

    bind<IdolsViewModel.Factory>() with singleton { IdolsViewModel.Factory(instance()) }
}
