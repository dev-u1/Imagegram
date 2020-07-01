package ulanapp.imagegram.ui.discover

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ulanapp.imagegram.data.repository.Repository

class DiscoverViewModelFactory(private var repository: Repository) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DiscoverViewModel(repository) as T
    }

}