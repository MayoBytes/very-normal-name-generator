package com.thirdgallon.namegenerator.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SavedName(
    @SerialName(ID)
    val id: String,
    @SerialName(NAME)
    val name: String,
    @SerialName(DESCRIPTION)
    val description: String,
) {

    override fun toString(): String {
        return "id: $id, name: $name, description:\n$description"
    }

    override fun equals(other: Any?): Boolean {
        other?.let {
            if (it is SavedName) {
                return it.name.lowercase() == name.lowercase()
            }
        }
        return false
    }

    companion object {
        const val ID = "id"
        const val NAME = "name"
        const val DESCRIPTION = "description"
    }
}