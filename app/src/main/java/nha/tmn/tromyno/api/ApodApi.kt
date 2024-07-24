package nha.tmn.tromyno.api

import nha.tmn.tromyno.models.ApodResponse
import nha.tmn.tromyno.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodApi {
    @GET("planetary/apod")
    suspend fun getApod(
        @Query("start_date")
        startDate: String = "2024-07-20",

        @Query("end_date")
        endDate: String?,

        @Query("api_key")
        apiKey: String = Constants.API_KEY
    ): Response<ApodResponse>
}