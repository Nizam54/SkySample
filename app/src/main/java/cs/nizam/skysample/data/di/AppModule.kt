package cs.nizam.skysample.data.di

import cs.nizam.skysample.data.repository.AssetsRepository
import cs.nizam.skysample.data.repository.AssetsRepoImpl
import cs.nizam.skysample.view.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::AssetsRepoImpl) {bind<AssetsRepository>()}
    viewModelOf(::MainViewModel)
}