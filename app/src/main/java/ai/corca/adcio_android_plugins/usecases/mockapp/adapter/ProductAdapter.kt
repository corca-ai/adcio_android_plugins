package ai.corca.adcio_android_plugins.usecases.mockapp.adapter

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.databinding.ItemProductBinding
import ai.corca.adcio_android_plugins.usecases.mockapp.adapter.model.Product
import ai.corca.adcio_android_plugins.usecases.mockapp.adapter.util.ProductDiffUtilCallback
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(
    val onClickItem: (logOption: AdcioLogOption) -> Unit
) : ListAdapter<Product, ProductAdapter.ProductViewHolder>(
    ProductDiffUtilCallback
) {

    inner class ProductViewHolder(private var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) = with(binding) {
            Glide.with(binding.root)
                .load(product.image)
                .centerCrop()
                .into(binding.ivImage)

            binding.tvName.text = product.name
            binding.tvBrand.text = product.brand
            binding.tvPrice.text = "${product.price}원"
            binding.tvSale.text = "${product.sale}%"

            binding.tvAd.visibility = if (product.isAd) View.VISIBLE else View.INVISIBLE

            if (product.isAd) {
                product.logOption?.let {
                    binding.adcioProduct.option = it
                }
            }
            binding.adcioProduct.useImpression = product.isAd

            binding.root.setOnClickListener {
                if (product.isAd) {
                    onClickItem(product.logOption ?: return@setOnClickListener)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductAdapter.ProductViewHolder {
        return ProductViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
