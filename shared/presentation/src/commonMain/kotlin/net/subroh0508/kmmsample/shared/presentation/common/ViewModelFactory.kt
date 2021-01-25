package net.subroh0508.kmmsample.shared.presentation.common

expect abstract class ViewModelFactory() {
    abstract fun <T: ViewModel> create(): T
}
