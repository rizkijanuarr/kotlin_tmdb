package udemy.lazday.kotlintmdb.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import udemy.lazday.kotlintmdb.data.response.NowPlayingResponse

interface Routes {

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("language") lang: String = "id-ID",
        @Query("page") page: Int
    ): NowPlayingResponse

}