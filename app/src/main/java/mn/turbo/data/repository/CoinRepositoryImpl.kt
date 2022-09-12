package mn.turbo.data.repository

import mn.turbo.data.remote.CoinApi
import mn.turbo.data.remote.dto.CoinDetailDto
import mn.turbo.data.remote.dto.CoinDto
import mn.turbo.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}
