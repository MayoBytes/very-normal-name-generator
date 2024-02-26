package com.thirdgallon.namegenerator.generator

interface FirstNames {
    fun complete(): Array<String>
    fun root(): Array<String>
    fun suffix(): Array<String>
}