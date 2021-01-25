package net.subroh0508.kmmsample.shared.presentation.common

import kotlinx.coroutines.Job

sealed class LoadState {
    object Initialize : LoadState()
    class Loading(val job: Job) : LoadState()
    data class Loaded<out T>(val value: T) : LoadState()
    data class Error(val error: Throwable) : LoadState()

    val isLoading get() = this is Loading

    @Suppress("UNCHECKED_CAST")
    fun <T> getValueOrNull(): T? = (this as? Loaded<T>)?.value
    fun getErrorOrNull(): Throwable? = (this as? Error)?.error
}
