package cs.nizam.skysample.data.repository

import cs.nizam.skysample.data.model.Movie
import cs.nizam.skysample.data.repository.network.SkyService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.mp.KoinPlatformTools

class AssetsRepoImpl : AssetsRepository {
    override suspend fun getPageContent(): Flow<List<Movie>> = flow {
        val skyService: SkyService by lazy { KoinPlatformTools.defaultContext().get().get() }
        emit(skyService.getAllMovies())
    }
}