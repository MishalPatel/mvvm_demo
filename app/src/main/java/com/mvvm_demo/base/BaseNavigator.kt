package com.mvvm_demo.base

import java.net.SocketTimeoutException

interface BaseNavigator {
    fun error(throwable: Throwable?) {

    }
}