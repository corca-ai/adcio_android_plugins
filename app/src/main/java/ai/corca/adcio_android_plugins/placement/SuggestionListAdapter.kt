package ai.corca.adcio_android_plugins.placement

import ai.corca.adcio_android_plugins.databinding.ItemSuggestionBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class SuggestionListAdapter : ListAdapter<Suggestion, SuggestionListAdapter.SuggestionViewHolder>(ProductDiffUtilCallback) {

    inner class SuggestionViewHolder(private var binding: ItemSuggestionBinding) : ViewHolder(binding.root) {
        fun bind(item: Suggestion) = with(binding) {
            Glide.with(binding.root)
                .load(item.image)
                .circleCrop()
                .into(binding.ivImage)

            binding.tvTitle.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder {
        return SuggestionViewHolder(
            ItemSuggestionBinding.inflate(
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

object ProductDiffUtilCallback : DiffUtil.ItemCallback<Suggestion>() {

    override fun areItemsTheSame(oldItem: Suggestion, newItem: Suggestion): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Suggestion, newItem: Suggestion): Boolean {
        return oldItem == newItem
    }
}
