package net.subroh0508.kmmsample.shared.presentation.di

import net.subroh0508.kmmsample.shared.presentation.IdolsViewModel
import org.kodein.di.*

@Suppress("FunctionName")
fun IdolsViewModelDI(
    vararg module: DI.Module,
) = IdolsViewModelDI(module.toList())

@Suppress("FunctionName")
fun IdolsViewModelDI(
    modules: List<DI.Module>
) = DI {
    modules.forEach { import(it) }

    bind<IdolsViewModel.Factory>() with singleton { IdolsViewModel.Factory(instance()) }
}
