package com.thirdgallon.namegenerator.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import com.thirdgallon.namegenerator.database.SavedName
import com.thirdgallon.namegenerator.database.SavedNameDatabase
import com.thirdgallon.namegenerator.database.UUID

class SavedNamesModel : ScreenModel {

    private var savedMap: MutableMap<String, SavedName> = mutableMapOf()
    private var _saved: MutableState<List<SavedName>> = mutableStateOf(listOf())
    val saved: State<List<SavedName>> = _saved

    init {
        refresh()
    }

    fun delete(id: String) {
        savedMap.remove(id)
        SavedNameDatabase.shared.deleteName(id)
        updateState()
    }

    fun contains(name: String): Boolean {
        return savedMap.containsValue(SavedName("", name, ""))
    }

    fun saveName(name: String, description: String?) {
        if (contains(name)) {
            return
        }

        val saved = SavedName(
            id = UUID().toString(),
            name,
            description = description ?: "",
        )

        savedMap[saved.id] = saved
        SavedNameDatabase.shared.writeName(saved)
        updateState()
    }

    fun refresh() {
        savedMap.clear()
        val names = SavedNameDatabase.shared.selectAll().toMutableList()
        names.forEach { savedMap[it.id] = it }
        updateState()
    }

    private fun updateState() {
        _saved.value = savedMap.values.toList()
    }
}