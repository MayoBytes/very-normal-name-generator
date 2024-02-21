package com.thirdgallon.namegenerator.generator

data class Options(
    var first: Boolean = true,
    var last: Boolean = true,
    var gender: Gender = Gender.MASC
)

enum class Gender(val gender: Int) {
    MASC(0),
    FEM(1),
    NEUT(2)
}