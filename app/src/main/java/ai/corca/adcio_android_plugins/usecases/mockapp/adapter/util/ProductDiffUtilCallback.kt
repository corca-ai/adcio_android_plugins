package ai.corca.adcio_android_plugins.usecases.mockapp.adapter.util

import ai.corca.adcio_android_plugins.usecases.mockapp.adapter.model.Product
import androidx.recyclerview.widget.DiffUtil

object ProductDiffUtilCallback : DiffUtil.ItemCallback<Product>() {

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}
