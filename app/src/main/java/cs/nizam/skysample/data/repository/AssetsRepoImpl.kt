package cs.nizam.skysample.data.repository

import android.content.Context
import cs.nizam.skysample.data.model.Movie
import cs.nizam.skysample.data.repository.network.RetrofitClientInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AssetsRepoImpl(private val context: Context): AssetsRepository {
    override suspend fun getPageContent(): Flow<List<Movie>> = flow {
        val skyService = RetrofitClientInstance.getSkyService(context)
        emit(skyService.getAllMovies())
    }
}