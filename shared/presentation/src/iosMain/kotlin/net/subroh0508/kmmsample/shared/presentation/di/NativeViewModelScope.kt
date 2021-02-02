package net.subroh0508.kmmsample.shared.presentation.di

import org.kodein.di.bindings.Scope
import org.kodein.di.bindings.UnboundedScope

@Suppress("UNCHECKED_CAST")
actual fun <T: Any> viewModelScope(): Scope<T> = UnboundedScope()
