package com.mvvm_demo.di.modules

import `in`.thirdwavecoffee.android.api.ApiServices
import com.mvvm_demo.viewModels.MainViewModel
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class ViewModelModule {

    @Provides
    fun providesMainActivity(apiServices: ApiServices): MainViewModel {
        return MainViewModel(apiServices)
    }
}