package ai.corca.adcio_android_plugins.analytics.utils

import androidx.recyclerview.widget.DiffUtil

object MockProductDiffUtilCallback : DiffUtil.ItemCallback<MockProduct>() {

    override fun areItemsTheSame(oldItem: MockProduct, newItem: MockProduct): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MockProduct, newItem: MockProduct): Boolean {
        return oldItem == newItem
    }
}
