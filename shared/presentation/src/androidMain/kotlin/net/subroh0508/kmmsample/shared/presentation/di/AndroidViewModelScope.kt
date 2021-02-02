package net.subroh0508.kmmsample.shared.presentation.di

import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.bindings.Scope

@Suppress("UNCHECKED_CAST")
actual fun <T: Any> viewModelScope(): Scope<T> = AndroidLifecycleScope as Scope<T>
