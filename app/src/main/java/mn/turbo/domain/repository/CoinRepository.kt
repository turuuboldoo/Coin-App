package mn.turbo.domain.repository

import mn.turbo.data.remote.dto.CoinDetailDto
import mn.turbo.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}
