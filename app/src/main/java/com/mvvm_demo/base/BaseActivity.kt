package com.mvvm_demo.base


import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity


abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<*>> : DaggerAppCompatActivity(), BaseNavigator {
    private val TAG = BaseActivity::class.java.simpleName

    protected lateinit var mActivity: AppCompatActivity

    private var mViewModel: V? = null
    private lateinit var mViewDataBinding: T


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this

        mViewDataBinding = DataBindingUtil.setContentView(this, findContentView())


        this.mViewModel = if (mViewModel == null) getViewModel() else mViewModel
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()


        onReady(savedInstanceState)
    }

    abstract fun getBindingVariable(): Int
    fun getViewDataBinding(): T {
        return mViewDataBinding
    }

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): V


    abstract fun onReady(savedInstanceState: Bundle?)

    @LayoutRes
    abstract fun findContentView(): Int
}