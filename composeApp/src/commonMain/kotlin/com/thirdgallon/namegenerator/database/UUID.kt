package com.thirdgallon.namegenerator.database

import com.benasher44.uuid.Uuid
import kotlinx.datetime.Clock
import kotlin.random.Random

class UUID {

    val uuid: Uuid = Uuid(random.nextLong(), random.nextLong())

    override fun toString(): String {
        return uuid.toString()
    }

    companion object {
        private val random = Random(Clock.System.now().epochSeconds)
    }
}