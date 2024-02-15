class NameGenerator {

    fun generate(first: Boolean, last: Boolean): String {

        var generated = ""

        if (first) {
            val firstIndex = (FIRST_NAMES.indices).random()
            generated += FIRST_NAMES[firstIndex]
        }

        if (last) {
            val lastIndex = (LAST_NAMES.indices).random()
            if (generated.isNotEmpty()) generated += " "
            generated += LAST_NAMES[lastIndex]
        }
        return generated
    }

    companion object {
        private val FIRST_NAMES = arrayOf(
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