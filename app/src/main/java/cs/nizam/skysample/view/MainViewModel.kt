package cs.nizam.skysample.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cs.nizam.skysample.data.model.Movie
import cs.nizam.skysample.data.repository.AssetsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
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
            repository.getPageContent()
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

}