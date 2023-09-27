package ai.corca.adcio_android_plugins.analytics.utils

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.databinding.ItemMockProductBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class MockProductListAdapter(
    val onClickPurchase: (logOption: AdcioLogOption) -> Unit,
    val onClickItem: (logOption: AdcioLogOption) -> Unit,
    val onAddToCart: () -> Unit
) : ListAdapter<MockProduct, MockProductListAdapter.MockProductViewHolder>(
    MockProductDiffUtilCallback
) {

    inner class MockProductViewHolder(private var binding: ItemMockProductBinding) : ViewHolder(binding.root) {
        fun bind(item: MockProduct) = with(binding) {

            // View will not work unless you enter a LogOption object
            // as an option in the AdcioImpressionDetector!
            binding.adcioDetector.option = item.logOption
            // You can get the recommended product and its Log Option
            // through the Suggestion function in your adcio_placement library.

            setOtherViews(item)
        }

        private fun setOtherViews(item: MockProduct) {
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
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MockProductViewHolder {
        return MockProductViewHolder(
            ItemMockProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: MockProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
