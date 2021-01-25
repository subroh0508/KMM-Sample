package net.subroh0508.kmmsample.shared.presentation.common

import androidx.lifecycle.ViewModel as AndroidViewModel
import androidx.lifecycle.viewModelScope as androidViewModelScope
import kotlinx.coroutines.CoroutineScope

actual abstract class ViewModel actual constructor(coroutineScope: CoroutineScope?) : AndroidViewModel() {
    actual val viewModelScope = coroutineScope ?: androidViewModelScope
}
