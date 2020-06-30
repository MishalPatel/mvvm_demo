package `in`.thirdwavecoffee.android.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*


interface ApiServices {


    @GET(URLFactory.EP_SUBSCRIPTIONS)
    fun subscriptions(@QueryMap requestParam: HashMap<String, Any>): Observable<ResponseBody>

}
