package net.subroh0508.kmmsample.shared.presentation

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun IdolsViewModel.getUiModel(
    block: (IdolsUiModel) -> Unit,
) = uiModel.onEach { block(it) }.launchIn(viewModelScope)
