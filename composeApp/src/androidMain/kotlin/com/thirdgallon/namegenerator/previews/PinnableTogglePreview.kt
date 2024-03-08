package com.thirdgallon.namegenerator.previews

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thirdgallon.namegenerator.composables.PinnableToggle

@Preview
@Composable
fun PinnableTogglePreview() {

    val enabled = remember { mutableStateOf(true) }
    val pinned = remember { mutableStateOf(false) }


    Card (
        shape = RoundedCornerShape(32.dp),
        elevation = 4.dp,
        modifier = Modifier.padding(10.dp),
        backgroundColor = MaterialTheme.colors.primarySurface
    ) {
        PinnableToggle(
            text = "Bingus " + if (enabled.value) ":O" else ":3",
            enabled = enabled,
            onToggle = { enabled.value = !enabled.value },
            pinned = pinned,
            onPinToggle = { pinned.value = !pinned.value }
        )
    }
}