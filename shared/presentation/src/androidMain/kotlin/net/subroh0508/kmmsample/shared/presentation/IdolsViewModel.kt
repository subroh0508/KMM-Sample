package net.subroh0508.kmmsample.shared.presentation

import net.subroh0508.kmmsample.shared.data.infra.repository.IdolsRepository

fun factory() = IdolsViewModel.Factory(IdolsRepository())
