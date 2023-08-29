package ai.corca.adcio_android_plugins.analytics

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.databinding.ItemAnalyticsSuggestionBinding
import ai.corca.adcio_android_plugins.databinding.ItemSuggestionBinding
import ai.corca.adcio_android_plugins.placement.ProductDiffUtilCallback
import ai.corca.adcio_android_plugins.placement.Suggestion
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class AnalyticsSuggestionListAdapter(
    val onClickPurchase: (logOption: AdcioLogOption) -> Unit
) : ListAdapter<Suggestion, AnalyticsSuggestionListAdapter.AnalyticsSuggestionViewHolder>(
    ProductDiffUtilCallback
) {

    inner class AnalyticsSuggestionViewHolder(private var binding: ItemAnalyticsSuggestionBinding) : ViewHolder(binding.root) {
        fun bind(item: Suggestion) = with(binding) {
            Glide.with(binding.root)
                .load(item.image)
                .centerCrop()
                .into(binding.ivAnalyticsImage)

            binding.tvName.text = item.name
            binding.tvPrice.text = "₩${item.price}"
            binding.layoutPurchase.setOnClickListener {
                onClickPurchase(item.logOption)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnalyticsSuggestionViewHolder {
        return AnalyticsSuggestionViewHolder(
            ItemAnalyticsSuggestionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: AnalyticsSuggestionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
