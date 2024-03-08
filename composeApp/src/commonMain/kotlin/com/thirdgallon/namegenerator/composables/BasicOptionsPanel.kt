package com.thirdgallon.namegenerator.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thirdgallon.namegenerator.generator.Gender
import com.thirdgallon.namegenerator.models.OptionsModel


@Composable
fun BasicOptions(options: OptionsModel) {
    WrappedBasicOptionsPanel(
        first = options.first,
        toggleFirst = { options.toggleFirst() },
        lockFirst = options.lockFirst,
        toggleLockFirst = { options.toggleLockFirst() },
        last = options.last,
        toggleLast = { options.toggleLast() },
        lockLast = options.lockLast,
        toggleLockLast = { options.toggleLockLast() },
        gender = options.gender,
        setGender = { options.setGender(it) },
        explicit = options.explicit,
        toggleExplicit = { options.toggleExplicit() }
    )
}

@Composable
fun WrappedBasicOptionsPanel(
    first: State<Boolean>,
    toggleFirst: (Boolean) -> Unit,
    lockFirst: State<Boolean>,
    toggleLockFirst: (Boolean) -> Unit,
    last: State<Boolean>,
    toggleLast: (Boolean) -> Unit,
    lockLast: State<Boolean>,
    toggleLockLast: (Boolean) -> Unit,
    gender: State<Gender>,
    setGender: (Gender) -> Unit,
    explicit: State<Boolean>,
    toggleExplicit: (Boolean) -> Unit,
) {

    var showGenderPicker by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(18.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
    ) {

        OptionsRow {
            OptionsItem {
                PinnableToggle(
                    text = "First Name",
                    enabled = first,
                    onToggle = { toggleFirst(!first.value) },
                    pinned = lockFirst,
                    onPinToggle = { toggleLockFirst(!lockFirst.value) },
                )
            }
            OptionsItem {
                PinnableToggle(
                    text = "Last Name",
                    enabled = last,
                    onToggle = { toggleLast(!last.value) },
                    pinned = lockLast,
                    onPinToggle = { toggleLockLast(!lockLast.value) },
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
                    Text(stringForGender(gender.value))
                    DropdownMenu(
                        expanded = showGenderPicker,
                        onDismissRequest = { showGenderPicker = false },
                    ) {
                        Gender.entries.forEach { gender ->
                            DropdownMenuItem(onClick = {
                                setGender(gender)
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
                    state = explicit,
                    onToggle = toggleExplicit,
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