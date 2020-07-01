package ulanapp.imagegram.ui.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.lessons.img.R
import kotlinx.android.synthetic.main.discover_layout.*
import ulanapp.imagegram.data.model.Photo
import ulanapp.imagegram.data.model.PhotosResponse
import ulanapp.imagegram.data.repository.PixabayRepositoryImpl

class DiscoverFragment : Fragment() {

    private lateinit var discoverViewModel: DiscoverViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.discover_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = PixabayRepositoryImpl()

        discoverViewModel = ViewModelProvider(
            this,
            DiscoverViewModelFactory(repository)
        ).get(DiscoverViewModel::class.java)
        discoverViewModel.photos.observe(activity!!, object : Observer<PhotosResponse>{
            override fun onChanged(response: PhotosResponse?) {
                val resultPhotos = mutableListOf<Photo>()
                if (response != null) {
                    response.hits?.let { result ->
                        resultPhotos.addAll(result)
                        setupEditorsChoice(resultPhotos)
                    }
                }
            }

        })
        setupCategories()
    }

    private fun setupEditorsChoice(photos: List<Photo>) {
        val adapter = EditorChoiceAdapter(photos)
        val layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL, false)
        choices_recycler_view.layoutManager = layoutManager
        choices_recycler_view.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun setupCategories() {
        val adapter = CategoryAdapter()
        val layoutManager = GridLayoutManager(activity!!, 3)
        category_recycler_view.layoutManager = layoutManager
        category_recycler_view.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}