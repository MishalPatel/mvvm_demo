package com.mvvm_demo.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import com.mvvm_demo.MyApp
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<N : Any>(application: MyApp?):AndroidViewModel(application!!){
    val isLoading = ObservableBoolean(false)

    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected var mNavigator: WeakReference<N>? = null

    fun getNavigator(): N? {
        return mNavigator?.get()
    }

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }

    protected fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}