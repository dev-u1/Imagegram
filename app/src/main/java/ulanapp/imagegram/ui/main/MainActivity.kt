package ulanapp.imagegram.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lessons.img.R
import com.lessons.img.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import ulanapp.imagegram.helpers.DISCOVER_FRAGMENT
import ulanapp.imagegram.helpers.HOME_FRAGMENT
import ulanapp.imagegram.helpers.LIKED_FRAGMENT
import ulanapp.imagegram.listeners.CallFragmentListener
import ulanapp.imagegram.ui.discover.DiscoverFragment
import ulanapp.imagegram.ui.home.HomeFragment
import ulanapp.imagegram.ui.liked.LikedFragment

class MainActivity : AppCompatActivity(), CallFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var mainVewModel = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)

        val activityBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityBinding.mainViewModel = mainVewModel
        callFragment(HOME_FRAGMENT)

    }

    override fun callFragment(title: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, getFragmentByTitle(title))
            .addToBackStack(null)
            .commit()
    }

    private fun getFragmentByTitle(title: String): Fragment {
        return when (title) {
            HOME_FRAGMENT -> HomeFragment()
            DISCOVER_FRAGMENT -> DiscoverFragment()
            LIKED_FRAGMENT -> LikedFragment()
            else -> DiscoverFragment()
        }
    }

}
