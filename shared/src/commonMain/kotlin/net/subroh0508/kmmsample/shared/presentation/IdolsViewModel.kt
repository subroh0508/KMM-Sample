package net.subroh0508.kmmsample.shared.presentation

import kotlinx.coroutines.flow.*
import net.subroh0508.kmmsample.shared.model.Idol

class IdolsViewModel : ViewModel() {
    private val idolsState: MutableStateFlow<List<Idol>> = MutableStateFlow(idols)
    private val queryState: MutableStateFlow<String> = MutableStateFlow("")

    val uiModel: StateFlow<IdolsUiModel> get() = combine(idolsState, queryState) { idols, query ->
        IdolsUiModel(idols, query.takeIf(String::isNotBlank))
    }.distinctUntilChanged().stateIn(viewModelScope, SharingStarted.Eagerly, IdolsUiModel())

    fun search(query: String) {
        queryState.value = query
        idolsState.value =
            if (query.isBlank())
                idols
            else
                idols.filter { it.name.contains(query) || it.yomi.contains(query) }
    }

    private val idols get() = listOf(
        Idol("Asakura_Toru", "浅倉透", "あさくらとおる", "#50D0D0", 17, "東京", listOf("映画やドラマを見ること"), "https://idollist.idolmaster-official.jp/detail/50001"),
        Idol("Higuchi_Madoka", "樋口円香", "ひぐちまどか", "#BE1E3E", 17, "東京", listOf("別にないです"), "https://idollist.idolmaster-official.jp/detail/50018"),
        Idol("Fukumaru_Koito", "福丸小糸", "ふくまるこいと", "#7967C3", 16, "東京", listOf("読書"), "https://idollist.idolmaster-official.jp/detail/50019"),
        Idol("Ichikawa_Hinana", "市川雛菜", "いちかわひなな", "#FFC639", 15, "神奈川", listOf("なんでもそれなりに好き～"), "https://idollist.idolmaster-official.jp/detail/50004"),
    )
}
