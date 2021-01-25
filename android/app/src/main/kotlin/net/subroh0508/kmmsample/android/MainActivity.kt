package net.subroh0508.kmmsample.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.EditText
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import net.subroh0508.kmmsample.android.databinding.ActivityMainBinding
import net.subroh0508.kmmsample.shared.presentation.IdolsViewModel
import net.subroh0508.kmmsample.shared.presentation.factory

class MainActivity : AppCompatActivity() {
    private val viewModel: IdolsViewModel by viewModels(::factory)

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

        val searchItem = menu?.findItem(R.id.search) ?: return true
        val searchView = searchItem.actionView.findViewById<EditText>(R.id.query)

        searchView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = Unit
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = viewModel.search(s?.toString())
        })
        searchView.onEndDrawableClick {
            searchView.setText("")
            searchItem.collapseActionView()
        }

        return true
    }

    private fun onClickSearchMenu(item: MenuItem) {
        val searchView = item.actionView.findViewById<EditText>(R.id.query)

        searchView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = Unit
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = viewModel.search(s?.toString())
        })
    }
}

private fun EditText.onEndDrawableClick(block: (EditText) -> Unit) {
    setOnTouchListener { v, event ->
        val endDrawable = compoundDrawables[2] ?: return@setOnTouchListener false

        if (event.action == MotionEvent.ACTION_UP && (v.width - endDrawable.bounds.width()) <= event.x) {
            block(this)
        }

        false
    }
}
