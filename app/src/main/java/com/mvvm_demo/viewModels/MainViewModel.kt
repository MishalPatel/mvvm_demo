package com.mvvm_demo.viewModels

import `in`.thirdwavecoffee.android.api.ApiServices
import com.mvvm_demo.MyApp
import com.mvvm_demo.base.BaseViewModel
import com.mvvm_demo.navigatores.MainNavigator
import retrofit2.Retrofit
import javax.inject.Inject

class MainViewModel @Inject constructor(private val apiServices: ApiServices) :
    BaseViewModel<MainNavigator>(MyApp.getInstance()) {

//    fun getUser() = apiServices.subscriptions()
}