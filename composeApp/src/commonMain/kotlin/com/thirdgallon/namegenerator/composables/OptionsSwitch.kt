package com.thirdgallon.namegenerator.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OptionsSwitch(text: String, state: State<Boolean>, onToggle: (Boolean) -> Unit) {
    Text(text)
    Spacer(Modifier.padding(horizontal = 6.dp))
    Switch(
        checked = state.value,
        onCheckedChange = onToggle,
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colors.secondary,
            checkedTrackColor = MaterialTheme.colors.secondaryVariant,
            uncheckedThumbColor = MaterialTheme.colors.onPrimary,
            uncheckedTrackColor = MaterialTheme.colors.onSurface,
        )
    )
}