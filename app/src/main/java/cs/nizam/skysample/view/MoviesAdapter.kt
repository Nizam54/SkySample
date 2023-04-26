package cs.nizam.skysample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cs.nizam.skysample.R
import cs.nizam.skysample.data.model.Movie
import cs.nizam.skysample.databinding.MovieItemBinding

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private val movieList = listOf<Movie>(
        Movie(title = "First", "Genre1", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
        Movie(title = "Second", "Genre2", null),
    )

    class MoviesViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie) {
            binding.apply {
                movie = item
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binder = DataBindingUtil.inflate<MovieItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.movie_item,
            parent,
            false
        )
        return MoviesViewHolder(binder)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size;
    }
}