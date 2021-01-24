package net.subroh0508.kmmsample.android

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.subroh0508.kmmsample.android.databinding.ListitemIdolBinding
import net.subroh0508.kmmsample.shared.data.model.Idol
import net.subroh0508.kmmsample.shared.presentation.IdolsViewModel
import net.subroh0508.kmmsample.shared.presentation.getItem
import net.subroh0508.kmmsample.shared.presentation.getItemId
import net.subroh0508.kmmsample.shared.presentation.itemCount

class IdolsAdapter(
    private val inflater: LayoutInflater,
    private val viewModel: IdolsViewModel,
) : RecyclerView.Adapter<IdolsAdapter.ViewHolder>() {
    init { setHasStableIds(true) }

    override fun getItemCount() = viewModel.uiModel.itemCount
    override fun getItemId(position: Int) = viewModel.uiModel.getItemId(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(inflater, parent)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(viewModel.uiModel.getItem(position))

    class ViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
    ) : RecyclerView.ViewHolder(inflater.inflate(R.layout.listitem_idol, parent, false)) {
        private val binding by lazy { ListitemIdolBinding.bind(itemView) }

        fun bind(item: Idol) = with (binding) {
            name.text = item.name
            yomi.text = item.yomi
            color.setBackgroundColor(Color.parseColor(item.color))
        }
    }
}
