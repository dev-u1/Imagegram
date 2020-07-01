package ulanapp.imagegram.ui.discover

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.lessons.img.R
import ulanapp.imagegram.data.repository.Repository
import ulanapp.imagegram.listeners.OnCategoryClickListener

class DiscoverViewModel(
    application: Application,
    repository: Repository,
    listener: OnCategoryClickListener
) : AndroidViewModel(application) {

    val category = application.resources.getStringArray(R.array.category)



}