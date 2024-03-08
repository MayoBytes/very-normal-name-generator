package com.thirdgallon.namegenerator.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import co.touchlab.kermit.Logger
import com.thirdgallon.namegenerator.composables.SavedNameListItem
import com.thirdgallon.namegenerator.models.SavedNamesModel

object SavedScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val model = rememberScreenModel { SavedNamesModel() }

        Scaffold (
            topBar = {
                TopAppBar(
                    title = {
                        Text("Saved Names")
                    },
                    navigationIcon = {
                        IconButton(onClick = { navigator?.pop() }) {
                            Icon(Icons.Rounded.KeyboardArrowLeft, "back")
                        }
                    }
                )
            }
        ) {
            LazyColumn (
                modifier = Modifier.padding(18.dp).fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(count = model.saved.value.size, key = { model.saved.value[it].id }) {
                    SavedNameListItem(
                        savedName = model.saved.value[it],
                        onClick = { tapped -> Logger.i("${tapped.name} tapped") },
                        onDelete = { toDelete -> model.delete(toDelete.id) }
                    )
                }
            }
        }
    }
}