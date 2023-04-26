package cs.nizam.skysample.data.repository

import cs.nizam.skysample.data.model.Movie

interface AssetsRepository {
    suspend fun getPageContent(): List<Movie>
}