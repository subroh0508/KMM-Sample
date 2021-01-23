package net.subroh0508.kmmsample.shared.presentation

import kotlinx.coroutines.CoroutineScope

expect abstract class ViewModel constructor(coroutineScope: CoroutineScope? = null) {
    val viewModelScope: CoroutineScope
}
