package ai.corca.adcio_android_plugins.suggestion.utils

import ai.corca.adcio_android_plugins.suggestion.model.Production
import androidx.recyclerview.widget.DiffUtil

object MockProductDiffUtilCallback : DiffUtil.ItemCallback<Production>() {

    override fun areItemsTheSame(oldItem: Production, newItem: Production): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: Production, newItem: Production): Boolean {
        return oldItem == newItem
    }
}
