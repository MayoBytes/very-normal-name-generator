package com.thirdgallon.namegenerator.previews

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.thirdgallon.namegenerator.composables.SavedNameListItem
import com.thirdgallon.namegenerator.database.SavedName

@Preview
@Composable
fun SavedNameListItemPreview() {
    val savedName by remember { mutableStateOf(SavedName(
        id = "1234",
        name = "Jimothy Eric Stuart Clan Edritch Von Bimbleton",
        description = ""
    )) }

    SavedNameListItem(
        savedName = savedName,
        onClick = { /* TODO */ },
        onDelete = { /* TODO */ },
    )
}