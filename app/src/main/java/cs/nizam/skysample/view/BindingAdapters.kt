package cs.nizam.skysample.view

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import cs.nizam.skysample.data.model.Movie


@BindingAdapter("app:setAdapter")
fun setAdapter(
    recyclerView: RecyclerView,
    adapter: MoviesAdapter?
) {
    adapter?.let {
        recyclerView.adapter = it
    }
}

@BindingAdapter("app:submitList")
fun submitList(recyclerView: RecyclerView, list: List<Movie>?) {
    val adapter = recyclerView.adapter as MoviesAdapter?
    adapter?.updateData(list ?: listOf())
}

@BindingAdapter("app:manageState")
fun manageState(progressBar: ProgressBar, state: Boolean) {
    progressBar.visibility = if (state) View.VISIBLE else View.GONE
}

@BindingAdapter("app:setImage")
fun setImage(imageView: AppCompatImageView, image: String?) {
    Glide.with(imageView.context)
        .load(image)
        .into(imageView)
}