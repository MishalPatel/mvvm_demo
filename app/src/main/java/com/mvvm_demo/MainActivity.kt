package com.mvvm_demo

import android.os.Bundle
import com.mvvm_demo.base.BaseActivity
import com.mvvm_demo.databinding.ActivityMainBinding
import com.mvvm_demo.navigatores.MainNavigator
import com.mvvm_demo.viewModels.MainViewModel
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    MainNavigator {


    private val TAG = MainActivity::class.java.simpleName

    override fun getViewModel(): MainViewModel {
        return vm
    }


    @Inject
    lateinit var vm: MainViewModel

    @Inject
    lateinit var context: MyApp

    override fun getBindingVariable(): Int = BR.viewModel

    lateinit var mBinding: ActivityMainBinding

    override fun findContentView(): Int = R.layout.activity_main


    override fun onReady(savedInstanceState: Bundle?) {
        mBinding = getViewDataBinding()
        vm.setNavigator(this)

    }

    override fun onBackPressed() {
        // BackPressed event
    }
}