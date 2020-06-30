package `in`.thirdwavecoffee.android.api

import com.mvvm_demo.BuildConfig
import okhttp3.HttpUrl


object URLFactory {

    private var SCHEME = "https"
    private var PATH_NAME = "graphql/"
    private lateinit var HOST: String
    private var PORT: Int = 0
    private lateinit var API_PATH: String
    const val URL_TESTING = "twcrapi.internetofapp.com"
    const val URL_PROD = "api.thirdwavecoffee.in"

    fun provideHttpUrl(): HttpUrl {
        val httpUrl = HttpUrl.Builder()
        when {
            BuildConfig.BUILD_TYPE == "_testing" -> {
                HOST = URL_TESTING
                API_PATH = PATH_NAME
            }
            BuildConfig.BUILD_TYPE == "release" -> {
                HOST = URL_PROD
                API_PATH = PATH_NAME
            }
            else -> {
                SCHEME = "http"
                HOST = "192.168.43.89"
                PORT = 5000
                API_PATH = PATH_NAME
                httpUrl.port(PORT)
            }
        }
        return httpUrl
            .scheme(SCHEME)
            .host(HOST)
            .addPathSegments(API_PATH)
            .build()
    }

    const val EP_SUBSCRIPTIONS = "maps/api/distancematrix/json"

    /*------------------------- **************** ------------------------------------*/
}
