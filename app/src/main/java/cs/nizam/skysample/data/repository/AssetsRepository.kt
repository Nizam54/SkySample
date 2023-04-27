package cs.nizam.skysample.data.repository

import cs.nizam.skysample.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface AssetsRepository {
    suspend fun getPageContent(): Flow<List<Movie>>
}