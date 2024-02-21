package com.thirdgallon.namegenerator.generator

class NameGenerator {

    fun generate(options: Options): String {

        var generated = ""

        if (options.first) {
            generated += when(options.gender) {
                Gender.MASC -> MASC_FIRST_NAMES.random()
                Gender.FEM -> FEM_FIRST_NAMES.random()
                Gender.NEUT -> NEUT_FIRST_NAMES.random()
            }
        }

        if (options.last) {
            if (generated.isNotEmpty()) generated += " "
            generated += LAST_NAMES.random()
        }
        return generated
    }


    companion object {
        private val MASC_FIRST_NAMES = arrayOf(
            "Bill",
            "Tim",
            "Fred",
            "John",
            "Steven",
            "Rob",
            "Bob",
            "Jim",
            "Terry",
            "William",
            "Frank",
            "David",
        )

        private val FEM_FIRST_NAMES = arrayOf(
            "Delphine",
            "Jan",
            "Sarah",
            "Barbara",
            "Olivia",
            "Charlotte",
            "Mary",
            "Emily",
            "Mia",
            "Elizabeth",
            "Anna",
            "Irene",
        )

        private val NEUT_FIRST_NAMES = arrayOf(
            "Avery",
            "Kit",
            "Alex",
            "Finley",
            "Zephyr",
            "Kai",
            "Remi",
            "Frankie",
            "Ash",
            "Charlie",
            "Lux",
            "Koda",
        )

        private val LAST_NAMES = arrayOf(
            "Smith",
            "Johnson",
            "Sewerperson",
            "Jones",
            "Farmer",
            "Tomlinson",
            "Williams",
            "Brown",
            "Garcia",
            "Miller",
            "Davis",
            "Anderson",
            "Thompson",
        )
    }
}