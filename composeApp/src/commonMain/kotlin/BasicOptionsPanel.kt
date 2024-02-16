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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BasicOptionsPanel(options: MutableState<Options>) {

    var showGenderPicker by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(18.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text("First Name")
                Spacer(Modifier.padding(horizontal = 6.dp))
                Switch(
                    checked = options.value.first,
                    onCheckedChange = { options.value = options.value.toggleFirst() },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colors.secondary,
                        checkedTrackColor = MaterialTheme.colors.secondaryVariant,
                        uncheckedThumbColor = MaterialTheme.colors.onPrimary,
                        uncheckedTrackColor = MaterialTheme.colors.onSurface,
                    )
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text("Last Name")
                Spacer(Modifier.padding(horizontal = 6.dp))
                Switch(
                    checked = options.value.last,
                    onCheckedChange = { options.value = options.value.toggleLast() },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colors.secondary,
                        checkedTrackColor = MaterialTheme.colors.secondaryVariant,
                        uncheckedThumbColor = MaterialTheme.colors.onPrimary,
                        uncheckedTrackColor = MaterialTheme.colors.onSurface,
                    )
                )
            }
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {

        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Text("Gender")
            Spacer(Modifier.padding(10.dp))
            OutlinedButton(
                shape = RoundedCornerShape(32.dp),
                onClick = { showGenderPicker = !showGenderPicker }
            ) {
                Text(stringForGender(options.value.gender))
                DropdownMenu(
                    expanded = showGenderPicker,
                    onDismissRequest = { showGenderPicker = false },
                ) {
                    Gender.entries.forEach { genderByte ->
                        DropdownMenuItem(onClick = {
                            options.value = options.value.setGender(genderByte)
                            showGenderPicker = false
                        }) {
                            Text(stringForGender(genderByte))
                        }
                    }
                }
            }
        }
    }
}

fun stringForGender(gender: Gender) : String {
    return when (gender) {
        Gender.MASC -> "Masculine"
        Gender.FEM -> "Feminine"
        Gender.NEUT -> "Neutral"
    }
}