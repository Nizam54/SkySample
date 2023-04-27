package cs.nizam.skysample.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cs.nizam.skysample.data.model.Movie
import cs.nizam.skysample.data.repository.AssetsRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(val repository: AssetsRepository) : ViewModel() {
    private val _fullMovieList = arrayListOf<Movie>()
    private var _filterText = ""
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
                    _fullMovieList.clear()
                    _fullMovieList.addAll(list)
                    _movieList.value = list
                }
        }
    }

    fun filterList(query: String) {
        if (_filterText != query) {
            _filterText = query
            if (query.isNotEmpty() && _fullMovieList.isNotEmpty()) {
                val filteredList = arrayListOf<Movie>()
                for (item in _fullMovieList) {
                    if (item.title!!.lowercase().contains(query.lowercase()) ||
                        item.genre!!.lowercase().contains(query.lowercase())
                    ) {
                        filteredList.add(item)
                    }
                }
                _movieList.value = filteredList
            } else {
                _movieList.value = _fullMovieList
            }
        }
    }

}