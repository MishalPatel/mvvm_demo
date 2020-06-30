package com.mvvm_demo

import android.app.Activity
import androidx.appcompat.app.AppCompatDelegate
import com.mvvm_demo.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApp : DaggerApplication() {
    operator fun get(activity: Activity): MyApp {
        return activity.application as MyApp
    }

    companion object {
        private var mInstance: MyApp? = null

        @Synchronized
        fun getInstance(): MyApp? {
            return mInstance
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}