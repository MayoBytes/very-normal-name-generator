package com.thirdgallon.namegenerator.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import com.thirdgallon.namegenerator.generator.Gender
import com.thirdgallon.namegenerator.generator.Options
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set

val settings: Settings = Settings()

const val OPTIONS_GEN_FIRST_NAME = "options_gen_first_name"
const val OPTIONS_GEN_LAST_NAME = "options_gen_last_name"
const val OPTIONS_GEN_EXPLICIT = "options_gen_explicit"
const val OPTIONS_GENDER = "options_gender"
class OptionsModel: ScreenModel {


    private val _first = mutableStateOf(settings[OPTIONS_GEN_FIRST_NAME, true])
    val first: State<Boolean> = _first

    private val _last = mutableStateOf(settings[OPTIONS_GEN_LAST_NAME, true])
    val last: State<Boolean> = _last

    private val _explicit = mutableStateOf(settings[OPTIONS_GEN_EXPLICIT, true])
    val explicit: State<Boolean> = _explicit

    private val _gender = mutableStateOf(Gender.entries.first { it.gender == settings[OPTIONS_GENDER, Gender.MASC.gender]})
    val gender: State<Gender> = _gender

    fun toggleFirst() {
        settings[OPTIONS_GEN_FIRST_NAME] = toggle(_first)
    }

    fun toggleLast() {
        settings[OPTIONS_GEN_LAST_NAME] = toggle(_last)
    }

    fun toggleExplicit() {
        settings[OPTIONS_GEN_EXPLICIT] = toggle(_explicit)
    }

    fun setGender(gender: Gender) {
        _gender.value = gender
        settings[OPTIONS_GENDER] = gender.gender
    }

    fun getOptions(): Options {
        return Options(
            first = first.value,
            last = last.value,
            explicit = explicit.value,
            gender = gender.value,
        )
    }

    private fun toggle(state: MutableState<Boolean>): Boolean {
        state.value = !state.value
        return state.value
    }
}