package mn.turbo.data.remote

import mn.turbo.data.remote.dto.CoinDetailDto
import mn.turbo.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

}
