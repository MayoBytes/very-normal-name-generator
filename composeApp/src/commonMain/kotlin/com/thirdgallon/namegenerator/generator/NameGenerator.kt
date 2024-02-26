package com.thirdgallon.namegenerator.generator

import kotlinx.datetime.Clock
import kotlin.random.Random

class NameGenerator {

    private var random = Random(Clock.System.now().epochSeconds)
    private var lastGenerated = ""
    private val masculineNames = MasculineNames()
    private val feminineNames = FeminineNames()

    fun generate(options: Options): String {

        var generated = ""

        if (options.first) {
            generated += when(options.gender) {
                Gender.MASC -> generateFirstName(masculineNames)
                Gender.FEM -> generateFirstName(feminineNames)
                Gender.NEUT -> NeutralNames.COMPLETE.random()
            }
        }

        if (options.last) {
            if (generated.isNotEmpty()) generated += " "
            generated += generateSurname(options.explicit)
        }

        lastGenerated = generated
        return generated
    }

    fun generateFirstName(firstNames: FirstNames): String {
        if (roll(COMPLETE_CHANCE)) {
            return firstNames.complete().random()
        }
        else {
            return firstNames.root().random() + firstNames.suffix().random()
        }
    }

    fun generateSurname(explicit: Boolean): String {
        if (roll(COMPLETE_CHANCE)) {
            return Surnames.COMPLETE.random()
        }
        else {
            val rootList = if (explicit) Surnames.ROOT_EXPLICIT else Surnames.ROOT
            val suffixList = if (explicit) Surnames.SUFFIX_EXPLICIT else Surnames.SUFFIX

            var base = rootList.random()

            if (roll(SURNAME_PREFIX_CHANCE)) {
                base = Surnames.PREFIX.random() + base
            }
            if (roll(SURNAME_SUFFIX_CHANCE)) {
                base += suffixList.random()
            }
            if (roll(SURNAME_DOUBLE_SUFFIX_CHANCE)) {
                base += suffixList.random()
            }

            return base
        }
    }

    fun getLastGenerated(): String {
        return lastGenerated
    }

    private fun roll(chance: Double): Boolean {
        return random.nextDouble(0.0, 1.0) <= chance
    }

    companion object {
        val shared = NameGenerator()
        private const val COMPLETE_CHANCE = 0.2
        private const val SURNAME_PREFIX_CHANCE = 0.15
        private const val SURNAME_SUFFIX_CHANCE = 0.9
        private const val SURNAME_DOUBLE_SUFFIX_CHANCE = 0.4
    }
}