package net.subroh0508.kmmsample.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import net.subroh0508.kmmsample.android.databinding.ActivityMainBinding
import net.subroh0508.kmmsample.shared.infra.repository.IdolsRepository
import net.subroh0508.kmmsample.shared.presentation.IdolsViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: IdolsViewModel by viewModels { IdolsViewModel.Factory(IdolsRepository()) }

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

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    onClickSearchMenu(menuItem)
                    return@setOnMenuItemClickListener true
                }
            }

            return@setOnMenuItemClickListener false
        }

        viewModel.uiModel.onEach {
            idolsAdapter.notifyDataSetChanged()
        }.launchIn(lifecycleScope)
    }

    override fun onResume() {
        super.onResume()

        viewModel.search()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    private fun onClickSearchMenu(item: MenuItem) {
        val searchView = item.actionView as SearchView

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String?) = true
        })
    }
}
