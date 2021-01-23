package net.subroh0508.kmmsample.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import net.subroh0508.kmmsample.android.databinding.ActivityMainBinding
import net.subroh0508.kmmsample.shared.presentation.IdolsViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: IdolsViewModel by viewModels()

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val idolsAdapter by lazy { IdolsAdapter(layoutInflater, viewModel) }
    private val idolsLayoutManager by lazy { LinearLayoutManager(this) }
    private val dividerItemDecoration by lazy { DividerItemDecoration(this, VERTICAL) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)

        with (binding.recyclerView) {
            adapter = idolsAdapter
            layoutManager = idolsLayoutManager
            addItemDecoration(dividerItemDecoration)
        }

        viewModel.uiModel.onEach {
            idolsAdapter.notifyDataSetChanged()
        }.launchIn(lifecycleScope)
    }
}
