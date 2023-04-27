package cs.nizam.skysample.data.repository.network

import cs.nizam.skysample.data.model.Movie
import retrofit2.http.GET

interface SkyService {
    @GET("759fdfa82d6f33522e11")
    suspend fun getAllMovies(): List<Movie>
}