package net.subroh0508.kmmsample.shared.presentation.common

import androidx.lifecycle.ViewModelProvider

actual abstract class ViewModelFactory : ViewModelProvider.Factory {
    actual abstract fun <T: ViewModel> create(): T

    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T = create() as T
}
