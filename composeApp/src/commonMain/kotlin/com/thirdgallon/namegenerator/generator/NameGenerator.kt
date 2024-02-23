package com.thirdgallon.namegenerator.generator

import kotlinx.datetime.Clock
import kotlin.random.Random

class NameGenerator {

    private var random = Random(Clock.System.now().epochSeconds)
    private var lastGenerated = ""

    fun generate(options: Options): String {

        var generated = ""

        if (options.first) {
            generated += when(options.gender) {
                Gender.MASC -> generateMasculine()
                Gender.FEM -> Names.Feminine.COMPLETE.random()
                Gender.NEUT -> Names.Neutral.COMPLETE.random()
            }
        }

        if (options.last) {
            if (generated.isNotEmpty()) generated += " "
            generated += generateSurname()
        }

        lastGenerated = generated
        return generated
    }

    fun generateMasculine(): String {
        if (random.nextDouble(0.0, 1.0) <= COMPLETE_CHANCE) {
            return Names.Masculine.COMPLETE.random()
        }
        else {
            return Names.Masculine.ROOT.random() + Names.Masculine.SUFFIX.random()
        }
    }

    fun generateSurname():String {
        if (roll(COMPLETE_CHANCE)) {
            return Names.Surname.COMPLETE.random()
        }
        else {
            val base = Names.Surname.ROOT.random() + Names.Surname.SUFFIX.random()
            if (roll(SURNAME_PREFIX_CHANCE)) {
                return Names.Surname.PREFIX.random() + base
            }
            else return base
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
        private const val COMPLETE_CHANCE = 0.3
        private val SURNAME_PREFIX_CHANCE = 0.15
    }
}