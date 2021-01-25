package net.subroh0508.kmmsample.shared.presentation

import kotlinx.coroutines.flow.StateFlow

fun StateFlow<IdolsUiModel>.getItemId(position: Int) = value.items[position].id.hashCode().toLong()
