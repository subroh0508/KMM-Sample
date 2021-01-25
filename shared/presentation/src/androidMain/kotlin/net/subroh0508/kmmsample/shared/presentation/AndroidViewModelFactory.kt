package net.subroh0508.kmmsample.shared.presentation

import androidx.lifecycle.ViewModel as AndroidViewModel
import androidx.lifecycle.ViewModelProvider

actual abstract class ViewModelFactory : ViewModelProvider.Factory {
    actual abstract fun <T: ViewModel> create(): T

    override fun <T : AndroidViewModel> create(modelClass: Class<T>): T = create() as T
}
