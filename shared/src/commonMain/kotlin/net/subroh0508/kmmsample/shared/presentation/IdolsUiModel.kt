package net.subroh0508.kmmsample.shared.presentation

import kotlinx.coroutines.flow.StateFlow
import net.subroh0508.kmmsample.shared.model.Idol

data class IdolsUiModel(
    val items: List<Idol> = listOf(),
    val query: String? = null,
)

val StateFlow<IdolsUiModel>.itemCount get() = value.items.size
fun StateFlow<IdolsUiModel>.getItem(position: Int) = value.items[position]
