package cs.nizam.skysample.data.repository.network

import android.content.Context
import cs.nizam.skysample.util.isInternetAvailable
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClientInstance {
    private const val TIME_OUT: Long = 120
    private const val cacheSize = (5 * 1024 * 1024).toLong()
    private const val BASE_URL = "https://api.npoint.io/"

    fun getSkyService(context: Context): SkyService {

        val myCache = Cache(context.cacheDir, cacheSize)

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .cache(myCache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (isInternetAvailable(context))
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                else
                    request.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 10)
                        .build()
                chain.proceed(request)
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(SkyService::class.java)
    }
}