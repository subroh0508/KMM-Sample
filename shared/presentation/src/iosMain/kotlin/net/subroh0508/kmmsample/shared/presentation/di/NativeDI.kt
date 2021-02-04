package net.subroh0508.kmmsample.shared.presentation.di

import net.subroh0508.kmmsample.shared.presentation.IdolsViewModel
import org.kodein.di.DI
import org.kodein.di.direct
import org.kodein.di.instance

fun createViewModel(di: DI): IdolsViewModel = di.direct.instance<IdolsViewModel.Factory>().create()
