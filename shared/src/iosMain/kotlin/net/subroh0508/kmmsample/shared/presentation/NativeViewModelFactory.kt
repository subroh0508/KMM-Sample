package net.subroh0508.kmmsample.shared.presentation

actual abstract class ViewModelFactory {
    actual abstract fun <T: ViewModel> create(): T
}
