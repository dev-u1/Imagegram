package ulanapp.imagegram.ui.discover

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ulanapp.imagegram.data.model.PhotosResponse
import ulanapp.imagegram.data.repository.Repository
import ulanapp.imagegram.listeners.OnDetailsClickListener
import ulanapp.imagegram.ui.base.BaseViewModel

class DiscoverViewModel(
    private var repository: Repository
) : BaseViewModel() {

    private var disposable: CompositeDisposable = CompositeDisposable()
    var photos = MutableLiveData<PhotosResponse>()

    init {
        loadPhotos()
    }

    private fun loadPhotos() {
        disposable.add(repository.getEditorChoicePhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> photos.value = result },
                { error -> Log.d("ulanbek", "$error") }
            ))

    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}