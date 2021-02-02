package net.subroh0508.kmmsample.shared.presentation.di

import net.subroh0508.kmmsample.shared.presentation.IdolsViewModel
import org.kodein.di.*
import org.kodein.di.bindings.Scope

object IdolsViewModel {
    @Suppress("FunctionName")
    inline fun <reified T: Any> DI(
        scope: Scope<T> = viewModelScope(),
        vararg module: DI.Module,
    ) = DI {
        module.forEach { import(it) }

        bind<IdolsViewModel.Factory>() with scoped(scope).singleton { IdolsViewModel.Factory(instance()) }
    }
}
