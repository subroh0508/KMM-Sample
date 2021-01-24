package net.subroh0508.kmmsample.shared.presentation

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.subroh0508.kmmsample.shared.infra.repository.IdolsRepository
import kotlin.reflect.KClass

class IdolsViewModel(
    private val repository: IdolsRepository,
) : ViewModel() {
    private val idolsLoadState: MutableStateFlow<LoadState> = MutableStateFlow(LoadState.Initialize)
    private val queryState: MutableStateFlow<String> = MutableStateFlow("")

    val uiModel: StateFlow<IdolsUiModel> get() = combine(
        idolsLoadState,
        queryState,
    ) { idolsLoadState, _ ->
        IdolsUiModel(idolsLoadState)
    }.distinctUntilChanged().stateIn(viewModelScope, SharingStarted.Eagerly, IdolsUiModel())

    fun search(query: String? = null) {
        val job = viewModelScope.launch(start = CoroutineStart.LAZY) {
            runCatching {
                withContext(Dispatchers.Default) {
                    repository.search(query)
                }
            }
                .onSuccess {
                    println(it)
                    idolsLoadState.value = LoadState.Loaded(it)
                }
                .onFailure {
                    it.printStackTrace()
                    idolsLoadState.value = LoadState.Error(it)
                }
        }

        idolsLoadState.value = LoadState.Loading(job)
        job.start()
    }

    class Factory(
        private val repository: IdolsRepository,
    ) : ViewModelFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create() = IdolsViewModel(repository) as T
    }
}
