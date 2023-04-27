package cs.nizam.skysample.view

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import cs.nizam.skysample.R
import cs.nizam.skysample.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel:MainViewModel by viewModel()
    private lateinit var movieAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        movieAdapter = MoviesAdapter()
        binding.apply {
            viewModel = this@MainActivity.mainViewModel
            lifecycleOwner = this@MainActivity
            adapter = movieAdapter
            layoutManager =
                GridLayoutManager(this@MainActivity, resources.getInteger(R.integer.grid_span_count))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchView = menu!!.findItem(R.id.action_search)
            .actionView as SearchView
        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    when {
                        query.length >= 3 -> {
                            mainViewModel.filterList(query)
                        }
                        query.isEmpty() -> {
                            mainViewModel.filterList(query)
                        }
                        else -> {
                            val snack = Snackbar.make(
                                binding.list,
                                "Please enter at least 3 chars to search",
                                Snackbar.LENGTH_SHORT
                            )
                            val view: View = snack.view
                            val params =
                                view.layoutParams as FrameLayout.LayoutParams
                            params.gravity = Gravity.BOTTOM
                            view.layoutParams = params
                            snack.animationMode = BaseTransientBottomBar.ANIMATION_MODE_FADE
                            snack.show()
                        }
                    }
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    if (newText.length >= 3 || newText.isEmpty()) {
                        mainViewModel.filterList(newText)
                    } else {
                        mainViewModel.filterList("")
                    }
                }
                return false
            }
        })
        return true
    }
}