package com.thirdgallon.namegenerator

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.resources.ExperimentalResourceApi

import com.thirdgallon.namegenerator.screens.MainScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        Navigator(MainScreen)
    }
}