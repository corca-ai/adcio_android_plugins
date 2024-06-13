package ai.corca.adcio_android_plugins.suggestion.utils

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.databinding.ItemMockProductBinding
import ai.corca.adcio_android_plugins.suggestion.model.Production
import android.graphics.Rect
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MockProductListAdapter(
    val onImpressionItem: (logOption: AdcioLogOption) -> Unit,
    val onPurchaseItem: (logOption: AdcioLogOption) -> Unit,
    val onClickItem: (logOption: AdcioLogOption) -> Unit,
    val onAddToCart: (productId: String) -> Unit
) : ListAdapter<Production, MockProductListAdapter.MockProductViewHolder>(
    MockProductDiffUtilCallback
) {

    private val handler = Handler(Looper.getMainLooper())
    private val visibleItemsMap = mutableMapOf<Int, Runnable>()
    private val startTimeMap = mutableMapOf<Int, Long>()

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

    inner class MockProductViewHolder(private var binding: ItemMockProductBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Production) = with(binding) {
            setOtherViews(item)

            // Check screen 50% of the time for more than 1 second
            binding.root.post {
                startVisibilityCheck()
            }
        }

        //MARK: - Code that detects that a product as a suggestion is on the screen 50% of the time for more than 1 second
        fun startVisibilityCheck() {
            if (isViewVisibleForAtLeast50Percent(binding.root)) {
                if (!startTimeMap.containsKey(adapterPosition)) {
                    startTimeMap[adapterPosition] = System.currentTimeMillis()
                    val runnable = Runnable {
                        val currentTime = System.currentTimeMillis()
                        if (isViewVisibleForAtLeast50Percent(binding.root) && currentTime - startTimeMap[adapterPosition]!! >= 1000) {
                            impression(adapterPosition)
                            startTimeMap.remove(adapterPosition)
                            visibleItemsMap.remove(adapterPosition)
                        }
                    }
                    handler.postDelayed(runnable, 1000)
                    visibleItemsMap[adapterPosition] = runnable
                }
            } else {
                stopVisibilityCheck()
            }
        }

        private fun stopVisibilityCheck() {
            startTimeMap.remove(adapterPosition)
            visibleItemsMap[adapterPosition]?.let { handler.removeCallbacks(it) }
            visibleItemsMap.remove(adapterPosition)
        }

        private fun isViewVisibleForAtLeast50Percent(view: View): Boolean {
            val rect = Rect()
            val isVisible = view.getGlobalVisibleRect(rect)
            val visibleHeight = rect.height()
            val totalHeight = view.height

            return isVisible && visibleHeight >= totalHeight / 2
        }

        private fun impression(position: Int) {
            val item = getItem(position)
            if (item.isSuggested) {
                onImpressionItem(item.logOption)
            }
        }

        private fun setOtherViews(item: Production) {
            Glide.with(binding.root)
                .load(item.image)
                .into(binding.ivAnalyticsImage)

            binding.tvName.text = item.name
            binding.tvPrice.text = "₩${item.price}"

            binding.tvBuy.setOnClickListener {
                onPurchaseItem(item.logOption)
            }

            binding.cardAnalyticsSuggestion.setOnClickListener {
                if (item.isSuggested) {
                    onClickItem(item.logOption)
                }
            }

            binding.ivPurchase.setOnClickListener {
                onAddToCart(item.productId)
            }
        }
    }

    // 스크롤 이벤트를 감지하기 위해 RecyclerView.OnScrollListener 추가
    fun attachToRecyclerView(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                checkVisibleItems(recyclerView)
            }
        })
    }

    private fun checkVisibleItems(recyclerView: RecyclerView) {
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()
        val lastVisiblePosition = layoutManager.findLastVisibleItemPosition()

        for (position in firstVisiblePosition..lastVisiblePosition) {
            val viewHolder = recyclerView.findViewHolderForAdapterPosition(position) as? MockProductViewHolder
            viewHolder?.startVisibilityCheck()
        }
    }
}
