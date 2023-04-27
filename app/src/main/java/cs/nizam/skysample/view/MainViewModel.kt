package cs.nizam.skysample.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cs.nizam.skysample.data.model.Movie
import cs.nizam.skysample.data.repository.AssetsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(val repository: AssetsRepository): ViewModel() {
    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = _movieList
    private val _showProgressBar = MutableLiveData(false)
    val showProgressBar: LiveData<Boolean> = _showProgressBar
    init {
        loadMovieList()
    }

    private fun loadMovieList() {
        viewModelScope.launch {
            fetchMovies()
                .onStart {
                    _showProgressBar.postValue(true)
                }.catch { err ->
                    _showProgressBar.postValue(false)
                }
                .collect { list ->
                    _showProgressBar.postValue(false)
                    _movieList.value = list
                }
        }
    }

    private fun fetchMovies() = flow<List<Movie>> {
        //TODO retrofit
        delay(700)
        emit(listOf<Movie>(
            Movie(title = "First", "Genre1", null),
            Movie(title = "Second", "Genre2", null),
            Movie(title = "Second", "Genre2", null),
            Movie(title = "Second", "Genre2", null),
            Movie(title = "Second", "Genre2", "https://m.media-amazon.com/images/M/MV5BZWI3ZThmYzUtNDJhOC00ZWY4LThiNmMtZDgxNjE3Yzk4NDU1XkEyXkFqcGdeQXVyNTk5Nzg1NjQ@._V1_SX300.jpg"),
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
        ))
    }.flowOn(Dispatchers.IO)
}