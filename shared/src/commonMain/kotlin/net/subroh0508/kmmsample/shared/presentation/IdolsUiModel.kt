package net.subroh0508.kmmsample.shared.presentation

import net.subroh0508.kmmsample.shared.model.Idol

data class IdolsUiModel(
    val items: List<Idol> = listOf(),
    val query: String? = null,
)
