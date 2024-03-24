package com.thirdgallon.namegenerator.models

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import com.thirdgallon.namegenerator.database.SavedName
import com.thirdgallon.namegenerator.database.SavedNameDatabase
import com.thirdgallon.namegenerator.database.UUID

class SavedNamesModel : ScreenModel {

    private var _saved = mutableStateOf(mutableListOf(SavedName("", "", "")))
    val saved = _saved

    init {
        refresh()
    }

    fun delete(id: String) {
        SavedNameDatabase.shared.deleteName(id)
        refresh()
    }

    fun refresh() {
        _saved.value = SavedNameDatabase.shared.selectAll().toMutableList()
    }

    fun contains(name: String): Boolean {
        return _saved.value.contains(SavedName("", name, ""))
    }

    fun saveName(name: String, description: String?) {
        if (contains(name)) {
            return
        }

        SavedNameDatabase.shared.writeName(
            SavedName(
                id = UUID().toString(),
                name,
                description = description ?: "",
            )
        )
        refresh()
    }
}