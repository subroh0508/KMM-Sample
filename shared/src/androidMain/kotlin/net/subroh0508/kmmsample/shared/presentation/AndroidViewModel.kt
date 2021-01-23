package net.subroh0508.kmmsample.shared.presentation

import kotlinx.coroutines.CoroutineScope
import androidx.lifecycle.viewModelScope as androidViewModelScope
import androidx.lifecycle.ViewModel as AndroidViewModel

actual abstract class ViewModel actual constructor(coroutineScope: CoroutineScope?) : AndroidViewModel() {
    actual val viewModelScope = coroutineScope ?: androidViewModelScope
}
