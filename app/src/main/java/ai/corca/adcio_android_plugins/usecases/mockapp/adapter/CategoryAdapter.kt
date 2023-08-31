package ai.corca.adcio_android_plugins.usecases.mockapp.adapter

import ai.corca.adcio_android_plugins.databinding.ItemCategoryBinding
import ai.corca.adcio_android_plugins.usecases.mockapp.adapter.util.CategoryDiffUtilCallback
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CategoryAdapter : ListAdapter<String, CategoryAdapter.CategoryViewHolder>(
    CategoryDiffUtilCallback
) {

    inner class CategoryViewHolder(private var binding: ItemCategoryBinding) : ViewHolder(binding.root) {
        fun bind(name: String) = with(binding) {
            binding.tvName.text = name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
