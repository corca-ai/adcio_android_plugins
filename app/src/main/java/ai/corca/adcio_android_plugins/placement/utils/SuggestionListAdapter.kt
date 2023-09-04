package ai.corca.adcio_android_plugins.placement.utils

import ai.corca.adcio_android_plugins.databinding.ItemProductionBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class SuggestionListAdapter : ListAdapter<Production, SuggestionListAdapter.SuggestionViewHolder>(
    ProductionDiffUtilCallback
) {

    inner class SuggestionViewHolder(private var binding: ItemProductionBinding) : ViewHolder(binding.root) {
        fun bind(item: Production) = with(binding) {
            Glide.with(binding.root)
                .load(item.image)
                .circleCrop()
                .into(binding.ivImage)

            binding.tvTitle.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder {
        return SuggestionViewHolder(
            ItemProductionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: SuggestionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object ProductionDiffUtilCallback : DiffUtil.ItemCallback<Production>() {

    override fun areItemsTheSame(oldItem: Production, newItem: Production): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Production, newItem: Production): Boolean {
        return oldItem == newItem
    }
}
