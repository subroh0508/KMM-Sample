package net.subroh0508.kmmsample.shared.presentation

expect abstract class ViewModelFactory() {
    abstract fun <T: ViewModel> create(): T
}
