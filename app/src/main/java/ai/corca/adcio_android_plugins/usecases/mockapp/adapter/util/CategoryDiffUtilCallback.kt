package ai.corca.adcio_android_plugins.usecases.mockapp.adapter.util

import androidx.recyclerview.widget.DiffUtil

object CategoryDiffUtilCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}
