package net.subroh0508.kmmsample.shared.presentation

import kotlinx.coroutines.flow.StateFlow

val StateFlow<IdolsUiModel>.itemCount get() = value.items.size
fun StateFlow<IdolsUiModel>.getItem(position: Int) = value.items[position]
fun StateFlow<IdolsUiModel>.getItemId(position: Int) = value.items[position].id.hashCode().toLong()
