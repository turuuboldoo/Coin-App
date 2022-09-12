package mn.turbo.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mn.turbo.common.Resource
import mn.turbo.data.remote.dto.toCoin
import mn.turbo.data.remote.dto.toCoinDetail
import mn.turbo.domain.model.Coin
import mn.turbo.domain.model.CoinDetail
import mn.turbo.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())

            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "some error go to log"))
        } catch (e: IOException) {
            emit(Resource.Error("cant reach server. !!! IOException !!!"))
        }
    }
}
