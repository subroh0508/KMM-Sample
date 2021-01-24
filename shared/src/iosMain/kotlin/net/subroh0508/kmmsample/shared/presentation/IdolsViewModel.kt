package net.subroh0508.kmmsample.shared.presentation

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import net.subroh0508.kmmsample.shared.infra.repository.IdolsRepository

fun IdolsViewModel.getUiModel(
    block: (IdolsUiModel) -> Unit,
) = uiModel.onEach { block(it) }.launchIn(viewModelScope)

@Suppress("FunctionName")
fun create(): IdolsViewModel = IdolsViewModel.Factory(IdolsRepository()).create()
