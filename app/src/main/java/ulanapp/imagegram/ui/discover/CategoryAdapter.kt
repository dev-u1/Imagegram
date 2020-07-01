package ulanapp.imagegram.ui.discover

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lessons.img.databinding.CategoryItemBinding
import ulanapp.imagegram.data.Category
import ulanapp.imagegram.listeners.OnCategoryClickListener

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return Category.values().size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val category = Category.values()[position]
        holder.binding?.category = category
        holder.binding?.categoryClick = object : OnCategoryClickListener{
            override fun onCategoryClick(view: View) {
                Log.d("ulanbek", "Category Click " + category.name)
            }

        }
    }

    class CategoryHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding: CategoryItemBinding? = DataBindingUtil.bind<CategoryItemBinding>(itemView)
    }
}


