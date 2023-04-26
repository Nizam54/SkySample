package cs.nizam.skysample

import android.app.Application
import cs.nizam.skysample.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SkyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SkyApplication)
            modules(appModule)
        }
    }
}