package ulanapp.imagegram.ui.discover

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lessons.img.databinding.EditorChoiceItemBinding
import ulanapp.imagegram.data.model.Photo
import ulanapp.imagegram.listeners.OnItemClickListener

class EditorChoiceAdapter(mPhotos: List<Photo>) : RecyclerView.Adapter<EditorChoiceAdapter.ChoiceViewHolder>() {

    private var photos: List<Photo> = mPhotos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChoiceViewHolder {
        val binding = EditorChoiceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChoiceViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: ChoiceViewHolder, position: Int) {
        val photo = photos[position]
        holder.binding?.photo = photo
        holder.binding?.itemClick = object :
            OnItemClickListener {
            override fun onItemClick(view: View) {
                Log.d("ulanbek", "Click in adapter " + photo.imageSize)
            }
        }
    }

    class ChoiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding: EditorChoiceItemBinding? = androidx.databinding.DataBindingUtil.bind<com.lessons.img.databinding.EditorChoiceItemBinding>(itemView)

    }

}