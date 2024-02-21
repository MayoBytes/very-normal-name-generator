package com.thirdgallon.namegenerator.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.thirdgallon.namegenerator.composables.BasicOptionsPanel
import com.thirdgallon.namegenerator.models.OptionsModel

@Preview
@Composable
fun BasicOptionsPanelPreview() {
    val model = OptionsModel()
    BasicOptionsPanel(model)
}