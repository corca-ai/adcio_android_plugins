package ai.corca.adcio_android_plugins.usecases.mockapp.adapter

import ai.corca.adcio_android_plugins.databinding.ItemProductBinding
import ai.corca.adcio_android_plugins.usecases.mockapp.adapter.model.Product
import ai.corca.adcio_android_plugins.usecases.mockapp.adapter.util.ProductDiffUtilCallback
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter : ListAdapter<Product, ProductAdapter.ProductViewHolder>(
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

            if (product.isAd) binding.tvAd.visibility = View.VISIBLE
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