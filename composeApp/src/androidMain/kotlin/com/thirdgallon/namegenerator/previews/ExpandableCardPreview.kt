package com.thirdgallon.namegenerator.previews

import com.thirdgallon.namegenerator.composables.ExpandableCard
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ExpandableCardPreview() {
    ExpandableCard("Hello Preview") {
        Text(":3")
    }
}