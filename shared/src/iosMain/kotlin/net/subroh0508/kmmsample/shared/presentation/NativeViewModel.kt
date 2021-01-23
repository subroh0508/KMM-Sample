package net.subroh0508.kmmsample.shared.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

actual abstract class ViewModel actual constructor(coroutineScope: CoroutineScope?) {
    protected actual val viewModelScope = coroutineScope ?: MainScope()
}
