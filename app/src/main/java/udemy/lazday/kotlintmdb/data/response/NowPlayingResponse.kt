package udemy.lazday.kotlintmdb.data.response

import com.google.gson.annotations.SerializedName
import udemy.lazday.kotlintmdb.data.model.MovieModel

data class NowPlayingResponse(
    val page: Int,
    val results: List<MovieModel>,

    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
