package com.thirdgallon.namegenerator

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition

import com.thirdgallon.namegenerator.screens.MainScreen


@Composable
fun App() {
    MaterialTheme {
        Navigator(MainScreen) {
            SlideTransition(it)
        }
    }
}