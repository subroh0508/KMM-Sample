package net.subroh0508.kmmsample.shared.presentation

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import net.subroh0508.kmmsample.shared.data.infra.repository.IdolsRepository

fun IdolsViewModel.getUiModel(
    block: (IdolsUiModel) -> Unit,
) = uiModel.onEach { block(it) }.launchIn(viewModelScope)
