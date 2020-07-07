package io.github.marcusadriano.brawlinfo.service

import io.github.marcusadriano.brawlinfo.BiPlayerRequest
import io.github.marcusadriano.brawlinfo.BiPlayerResponse
import io.github.marcusadriano.brawlinfo.BrawlinfoServiceGrpc
import io.github.marcusadriano.brawlinfo.Config
import io.github.marcusadriano.brawlinfo.utils.PlayerUtils
import io.github.marcusadriano.brawlstars.BrawlStars
import io.github.marcusadriano.brawlstars.model.Player
import io.github.marcusadriano.brawlstars.model.Result
import io.github.marcusadriano.brawlstars.service.BrawlStarsService
import io.grpc.stub.StreamObserver
import mu.KotlinLogging

class BrawlinfoGrpcService():
        BrawlinfoServiceGrpc.BrawlinfoServiceImplBase() {

    private val serviceApi: BrawlStarsService
    private val logger = KotlinLogging.logger {}

    init {
        BrawlStars.setup(Config.getInstance().bsApiKey)
        serviceApi = BrawlStars.service()
    }

    fun getPlayerResponse(result: Result<Player>): BiPlayerResponse {
        val response: BiPlayerResponse
        response = when (result) {
            is Result.Success<Player> -> {
                BiPlayerResponse.newBuilder()
                        .setPlayer(PlayerUtils.getPlayer(result.data))
                        .build()
            }
            is Result.Error -> {
                BiPlayerResponse.newBuilder()
                        .setError(PlayerUtils.getError(result.data))
                        .build()
            }
        }
        return response
    }

    override fun getPlayer(request: BiPlayerRequest?, responseObserver: StreamObserver<BiPlayerResponse>?) {
        request?.let {
            logger.info { "Request= ${request.toString().replace("\n", "")}" }
            val result: Result<Player> = serviceApi.player(it.gameTag)
            responseObserver?.let {
                it.onNext(getPlayerResponse(result))
                it.onCompleted()
            }
        }
    }
}