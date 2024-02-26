package com.thirdgallon.namegenerator.generator

class MasculineNames: FirstNames {
    companion object {

        private val _COMMON_FIRST = arrayOf(
            "Aaron",
            "Abe",
            "Alan",
            "Arthur",
            "August",
            "Bill",
            "Bob",
            "Chris",
            "Cole",
            "Connor",
            "Dave",
            "Dean",
            "Don",
            "Emmett",
            "Frank",
            "Fred",
            "George",
            "Graham",
            "Ian",
            "Isaiah",
            "James",
            "Jeff",
            "Jim",
            "John",
            "Josh",
            "Juan",
            "Leon",
            "Luke",
            "Mark",
            "Matt",
            "Max",
            "Michael",
            "Nathan",
            "Oscar",
            "Paul",
            "Rob",
            "Roman",
            "Ron",
            "Steve",
            "Tim",
            "Will",
            "Zack",
        )

        private val COMPLETE = _COMMON_FIRST + arrayOf(
            "Andrew",
            "Abraham",
            "Barrett",
            "Beckham",
            "Charles",
            "Christopher",
            "David",
            "Donald",
            "Giovanni",
            "Henry",
            "Jesus",
            "Santiago",
            "Steven",
            "Terry",
            "William",
            "Zachary",
        )

        private val ROOT = _COMMON_FIRST + arrayOf(
            "An",
            "Hen",
            "Jos",
            "Kenn",
            "Kev",
            "Na",
            "Terr",
        )

        private val SUFFIX = arrayOf(
            "aham",
            "ald",
            "an",
            "ard",
            "ardo",
            "enson",
            "ery",
            "iah",
            "iel",
            "in",
            "inth",
            "kin",
            "lee",
            "mas",
            "othan",
            "othy",
            "ron",
            "shua",
            "son",
            "than",
            "thew",
            "tholomew",
            "thony",
            "tian",
            "topher",
            "us",
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