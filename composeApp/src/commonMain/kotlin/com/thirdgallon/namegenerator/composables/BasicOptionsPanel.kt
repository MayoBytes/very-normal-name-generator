package com.thirdgallon.namegenerator.composables

import com.thirdgallon.namegenerator.models.OptionsModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thirdgallon.namegenerator.generator.Gender


@Composable
fun BasicOptionsPanel(options: OptionsModel) {

    var showGenderPicker by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(18.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
    ) {

        OptionsRow {
            OptionsItem {
                OptionsSwitch(
                    text = "First Name",
                    state = options.first,
                    onToggle = { options.toggleFirst() },
                    enabled = !options.lockFirst.value,
                )
            }
            OptionsItem {
                OptionsSwitch(
                    text = "Last Name",
                    state = options.last,
                    onToggle = { options.toggleLast() },
                    enabled = !options.lockLast.value,
                )
            }
        }
        OptionsRow {
            OptionsItem {
                OptionsSwitch(
                    text = "Lock First Name",
                    state = options.lockFirst,
                    onToggle = { options.toggleLockFirst() },
                    enabled = options.first.value,
                )
            }
            OptionsItem {
                OptionsSwitch(
                    text = "Lock Last Name",
                    state = options.lockLast,
                    onToggle = { options.toggleLockLast() },
                    enabled = options.last.value,
                )
            }
        }
        OptionsRow {
            OptionsItem {
                Text("Gender")
                Spacer(Modifier.padding(10.dp))
                OutlinedButton(
                    shape = RoundedCornerShape(32.dp),
                    onClick = { showGenderPicker = !showGenderPicker }
                ) {
                    Text(stringForGender(options.gender.value))
                    DropdownMenu(
                        expanded = showGenderPicker,
                        onDismissRequest = { showGenderPicker = false },
                    ) {
                        Gender.entries.forEach { gender ->
                            DropdownMenuItem(onClick = {
                                options.setGender(gender)
                                showGenderPicker = false
                            }) {
                                Text(stringForGender(gender))
                            }
                        }
                    }
                }
            }
            OptionsItem {
                OptionsSwitch(
                    text = "NSFW",
                    state = options.explicit,
                    onToggle = { options.toggleExplicit() },
                )
            }
        }
    }
}

@Composable
fun OptionsItem(content: @Composable () -> Unit) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        content()
    }
}

@Composable
fun OptionsRow(content: @Composable () -> Unit) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
    ) {
        content()
    }
}

fun stringForGender(gender: Gender) : String {
    return when (gender) {
        Gender.MASC -> "Masculine"
        Gender.FEM -> "Feminine"
        Gender.NEUT -> "Neutral"
    }
}