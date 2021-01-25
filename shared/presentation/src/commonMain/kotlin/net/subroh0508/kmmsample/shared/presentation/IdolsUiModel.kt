package net.subroh0508.kmmsample.shared.presentation

import kotlinx.coroutines.flow.StateFlow
import net.subroh0508.kmmsample.shared.data.model.Idol
import net.subroh0508.kmmsample.shared.presentation.common.LoadState

data class IdolsUiModel(
    val items: List<Idol> = listOf(),
    val query: String? = null,
) {
    companion object {
        operator fun invoke(
            idolsLoadState: LoadState,
        ) = IdolsUiModel(idolsLoadState.getValueOrNull() ?: listOf())
    }
}

val StateFlow<IdolsUiModel>.itemCount get() = value.items.size
fun StateFlow<IdolsUiModel>.getItem(position: Int) = value.items[position]
