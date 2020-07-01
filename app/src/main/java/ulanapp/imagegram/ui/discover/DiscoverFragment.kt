package ulanapp.imagegram.ui.discover

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.lessons.img.R
import kotlinx.android.synthetic.main.discover_layout.*
import kotlinx.android.synthetic.main.home_layout.*
import ulanapp.imagegram.data.model.Photo
import ulanapp.imagegram.ui.home.PhotoAdapter

class DiscoverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.discover_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        val adapter = CategoryAdapter()
        val layoutManager = GridLayoutManager(activity!!, 3)
        category_recycler_view.layoutManager = layoutManager
        category_recycler_view.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}