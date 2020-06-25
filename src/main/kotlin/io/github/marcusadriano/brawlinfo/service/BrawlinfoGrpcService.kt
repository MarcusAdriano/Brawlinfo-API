package io.github.marcusadriano.brawlinfo.service

import io.github.marcusadriano.brawlinfo.BiPlayerRequest
import io.github.marcusadriano.brawlinfo.BiPlayerResponse
import io.github.marcusadriano.brawlinfo.BrawlinfoServiceGrpc
import io.github.marcusadriano.brawlinfo.Config
import io.github.marcusadriano.brawlstars.BrawlStars
import io.github.marcusadriano.brawlstars.model.Player
import io.github.marcusadriano.brawlstars.model.Result
import io.github.marcusadriano.brawlstars.service.BrawlStarsService
import io.grpc.stub.StreamObserver

class BrawlinfoGrpcService():
        BrawlinfoServiceGrpc.BrawlinfoServiceImplBase() {

    private val serviceApi: BrawlStarsService

    init {
        BrawlStars.setup(Config.getInstance().bsApiKey)
        serviceApi = BrawlStars.service()
    }

    override fun getPlayer(request: BiPlayerRequest?, responseObserver: StreamObserver<BiPlayerResponse>?) {
        val result: Result<Player> = serviceApi.player(request!!.gameTag)
        when (result) {
            is Result.Success -> {
                val player = result.data            }
            is Result.Error -> {

            }
        }
    }
}