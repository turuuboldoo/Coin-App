package mn.turbo.domain.use_case.get_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mn.turbo.common.Resource
import mn.turbo.data.remote.dto.toCoin
import mn.turbo.domain.model.Coin
import mn.turbo.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())

            val coins = repository.getCoins()
                .map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "some error go to log"))
        } catch (e: IOException) {
            emit(Resource.Error("cant reach server. !!! IOException !!!"))
        }
    }
}
