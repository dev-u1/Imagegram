package ulanapp.imagegram.ui.discover

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class CategoryImageAdapter {

    companion object{

        @BindingAdapter("imageRes")
        @JvmStatic
        fun ImageView.setPhoto(res: Int){
            Glide.with(context).load(res).into(this)
        }
    }
}