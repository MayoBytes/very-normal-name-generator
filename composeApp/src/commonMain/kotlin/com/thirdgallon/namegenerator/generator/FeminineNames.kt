package com.thirdgallon.namegenerator.generator

class FeminineNames: FirstNames {

    companion object {

        private val _COMMON_FIRST = arrayOf(
            "Alex",
            "Alice",
            "Ann",
            "Anna",
            "Audrey",
            "Bell",
            "Brook",
            "Clara",
            "Claire",
            "Daisy",
            "Eliza",
            "Eva",
            "Ever",
            "Grace",
            "Iris",
            "Ivy",
            "Jan",
            "Josie",
            "Juli",
            "Kay",
            "Leah",
            "Lucy",
            "Lydia",
            "Mary",
            "Mia",
            "Mila",
            "Nora",
            "Remi",
            "Riley",
            "Rose",
            "Sam",
            "Sarah",
            "Sky",
            "Summer",
            "Willow",
            "Zoe",
        )

        private val COMPLETE = _COMMON_FIRST + arrayOf(
            "Aurora",
            "Charlotte",
            "Delphine",
            "Eloise",
            "Irene",
            "Jasmine",
            "Josephine",
            "Mackenzie",
            "Madison",
            "Margaret",
            "Melody",
            "Olivia",
            "Penelope",
            "Scarlett",
        )

        private val ROOT = _COMMON_FIRST + arrayOf(
            "Al",
            "Am",
            "Bar",
            "Cor",
            "El",
            "Em",
            "Gab",
            "Lay",
            "Mad",
            "Mar",
            "Nat",
            "Pais",
            "Sar",
            "Val",
            "Vic",
            "Vio",
            "Viv",
        )

        private val SUFFIX = arrayOf(
            "a",
            "ah",
            "ala",
            "aline",
            "anor",
            "anny",
            "antha",
            "astasia",
            "bara",
            "beth",
            "elia",
            "ene",
            "entina",
            "ette",
            "ia",
            "ian",
            "iella",
            "ily",
            "ina",
            "ine",
            "ison",
            "la",
            "leigh",
            "ley",
            "lie",
            "livia",
            "ly",
            "lyne",
            "ry",
            "toria",
            "y",
        )
    }

    override fun complete(): Array<String> {
        return COMPLETE
    }

    override fun root(): Array<String> {
        return ROOT
    }

    override fun suffix(): Array<String> {
        return SUFFIX
    }
}