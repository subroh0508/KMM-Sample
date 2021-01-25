package net.subroh0508.kmmsample.shared.presentation.common

import kotlinx.coroutines.CoroutineScope

expect abstract class ViewModel constructor(coroutineScope: CoroutineScope? = null) {
    val viewModelScope: CoroutineScope
}
