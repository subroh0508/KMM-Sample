package net.subroh0508.kmmsample.shared.presentation.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

actual abstract class ViewModel actual constructor(coroutineScope: CoroutineScope?) {
    actual val viewModelScope = coroutineScope ?: MainScope()
}
