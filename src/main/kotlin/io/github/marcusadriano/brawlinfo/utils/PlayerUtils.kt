package io.github.marcusadriano.brawlinfo.utils

import io.github.marcusadriano.brawlinfo.BiBrawler
import io.github.marcusadriano.brawlinfo.BiError
import io.github.marcusadriano.brawlinfo.BiPlayer
import io.github.marcusadriano.brawlstars.model.*
import java.util.stream.Collectors

object PlayerUtils {

    @JvmStatic
    fun getError(model: Error): BiError {
        val biError = BiError.newBuilder()

        model.message?.let { biError.setMessage(it) }
        model.reason?.let { biError.setReason(it) }
        model.type?.let { biError.setType(it) }

        return biError.build()
    }

    @JvmStatic
    fun getPlayer(model: Player): BiPlayer {
        val builder = BiPlayer.newBuilder()
        model.club?.let { builder.setClub(getClub(it)) }
        model.powerPlayPoints?.let { builder.setPowerPlayPoints(it) }
        model.nameColor?.let { builder.setNameColor(it) }
        model.vs3Victories?.let { builder.setThreeVs3Victories(it) }
        model.isQualifiedFromChampionshipChallenge?.let { builder.setIsQualifiedFromChampionshipChallenge(it) }
        model.soloVictories?.let { builder.setSoloVictories(it) }
        model.duoVictories?.let { builder.setDuoVictories(it) }
        model.bestRoboRumbleTime?.let { builder.setBestRoboRumbleTime(it) }
        model.bestTimeAsBigBrawler?.let { builder.setBestTimeAsBigBrawler(it) }
        model.brawlers?.let { builder.addAllBrawlers(getBrawlers(it)) }

        builder.name = model.name
        builder.tag = model.tag
        builder.trophies = model.trophies!!
        builder.highestTrophies = model.highestTrophies!!
        builder.expLevel = model.expLevel!!.toLong()
        builder.expPoints = model.expPoints!!.toLong()

        return builder.build()
    }

    @JvmStatic
    private fun getBrawlers(brawlers: Collection<Brawler>): Iterable<BiBrawler> {
        return brawlers.stream()
                .map { getBrawler(it) }
                .collect(Collectors.toList())
    }

    @JvmStatic
    private fun getBrawler(brawler: Brawler): BiBrawler {
        return BiBrawler.newBuilder()
                .setId(brawler.id!!)
                .setName(brawler.name)
                .setPower(brawler.power!!)
                .setRank(brawler.rank!!)
                .setTrophies(brawler.trophies!!)
                .setHighestTrophies(brawler.highestTrophies!!)
                .addAllStarPowers(getItems(brawler.starPowers!!))
                .addAllGadgets(getItems(brawler.gadgets!!))
            .build()
    }

    @JvmStatic
    private fun getItems(items: Collection<Item>): MutableIterable<BiBrawler.Item>? {
        return items.stream()
                .map { getItem(it) }
                .collect(Collectors.toList())
    }

    @JvmStatic
    private fun getItem(item: Item): BiBrawler.Item {
        return BiBrawler.Item.newBuilder()
                .setName(item.name)
                .setId(item.id!!)
                .build()
    }

    @JvmStatic
    private fun getClub(club: Club): BiPlayer.Club {
        val builder =  BiPlayer.Club.newBuilder()
        club.name?.let { builder.setName(it) }
        club.tag?.let { builder.setTag(it) }
        return builder.build()
    }

}