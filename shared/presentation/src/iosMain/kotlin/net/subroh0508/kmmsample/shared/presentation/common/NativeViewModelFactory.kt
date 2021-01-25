package net.subroh0508.kmmsample.shared.presentation.common

actual abstract class ViewModelFactory {
    actual abstract fun <T: ViewModel> create(): T
}
