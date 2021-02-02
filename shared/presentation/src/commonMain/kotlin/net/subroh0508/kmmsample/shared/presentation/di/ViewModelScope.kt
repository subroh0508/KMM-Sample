package net.subroh0508.kmmsample.shared.presentation.di

import org.kodein.di.bindings.Scope

expect fun <T: Any> viewModelScope(): Scope<T>
