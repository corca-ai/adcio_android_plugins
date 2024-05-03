package ai.corca.adcio_android_plugins.suggestion.utils

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.databinding.ItemMockProductBinding
import ai.corca.adcio_android_plugins.suggestion.model.Production
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class MockProductListAdapter(
    val onImpressionItem: (logOption: AdcioLogOption) -> Unit,
    val onPurchaseItem: (logOption: AdcioLogOption) -> Unit,
    val onClickItem: (logOption: AdcioLogOption) -> Unit,
    val onAddToCart: (productId: String) -> Unit
) : ListAdapter<Production, MockProductListAdapter.MockProductViewHolder>(
    MockProductDiffUtilCallback
) {

    inner class MockProductViewHolder(private var binding: ItemMockProductBinding) : ViewHolder(binding.root) {
        fun bind(item: Production) = with(binding) {

            // View will not work unless you enter a LogOption object
            // as an option in the AdcioImpressionDetector!
            binding.adcioDetector.option = item.logOption
            // You can get the recommended product and its Log Option
            // through the Suggestion function in your adcio_placement library.

            setOtherViews(item)

            binding.root.post {
                // Impression and click are functions that only collect suggestion values from ADCIO.
                if (item.isSuggested) {
                    getVisiblePercentage()
                }
            }
        }

        private fun setOtherViews(item: Production) {
            Glide.with(binding.root)
                .load(item.image)
                .centerCrop()
                .into(binding.ivAnalyticsImage)

            binding.tvName.text = item.name
            binding.tvPrice.text = "₩${item.price}"

            binding.tvBuy.setOnClickListener {
                onPurchaseItem(item.logOption)
            }

            binding.cardAnalyticsSuggestion.setOnClickListener {
                // Impression and click are functions that only collect suggestion values from ADCIO.
                if (item.isSuggested) {
                    onClickItem(item.logOption)
                }
            }

            binding.ivPurchase.setOnClickListener {
                onAddToCart(item.productId)
            }
        }

        // Example function to calculate 50% of the view.
        fun getVisiblePercentage(): Int {
            val itemRect = Rect()
            val isItemVisible = binding.root.getGlobalVisibleRect(itemRect)
            val visibleArea = itemRect.height() * itemRect.width()
            val totalArea = binding.root.height * binding.root.width

            return if (isItemVisible && totalArea > 0) {
                (visibleArea * 100 / totalArea)
            } else 0
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
