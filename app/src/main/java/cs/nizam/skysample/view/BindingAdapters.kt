package cs.nizam.skysample.view

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("app:setAdapter")
fun setAdapter(
    recyclerView: RecyclerView,
    adapter: MoviesAdapter?
) {
    adapter?.let {
        recyclerView.adapter = it
    }
}