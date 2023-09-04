package ai.corca.adcio_android_plugins.analytics.utils

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.databinding.ItemAnalyticsProductionBinding
import ai.corca.adcio_android_plugins.placement.utils.ProductionDiffUtilCallback
import ai.corca.adcio_android_plugins.placement.utils.Production
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class AnalyticsProductionListAdapter(
    val onClickPurchase: (logOption: AdcioLogOption) -> Unit,
    val onClickItem: (logOption: AdcioLogOption) -> Unit,
) : ListAdapter<Production, AnalyticsProductionListAdapter.AnalyticsProductionViewHolder>(
    ProductionDiffUtilCallback
) {

    inner class AnalyticsProductionViewHolder(private var binding: ItemAnalyticsProductionBinding) : ViewHolder(binding.root) {
        fun bind(item: Production) = with(binding) {
            Glide.with(binding.root)
                .load(item.image)
                .centerCrop()
                .into(binding.ivAnalyticsImage)

            binding.tvName.text = item.name
            binding.tvPrice.text = "₩${item.price}"
            binding.layoutPurchase.setOnClickListener {
                onClickPurchase(item.logOption)
            }
            binding.cardAnalyticsSuggestion.setOnClickListener {
                onClickItem(item.logOption)
            }
            binding.adcioDetector.option = item.logOption
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnalyticsProductionViewHolder {
        return AnalyticsProductionViewHolder(
            ItemAnalyticsProductionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: AnalyticsProductionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
