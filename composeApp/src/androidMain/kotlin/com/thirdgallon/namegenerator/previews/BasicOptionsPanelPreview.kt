package com.thirdgallon.namegenerator.previews

import androidx.compose.foundation.layout.fillMaxWidth
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
import com.thirdgallon.namegenerator.composables.WrappedBasicOptionsPanel
import com.thirdgallon.namegenerator.generator.Gender


@Preview
@Composable
fun BasicOptionsPanelPreview() {

    val first = remember { mutableStateOf(false) }
    val lockFirst = remember { mutableStateOf(false) }
    val last = remember { mutableStateOf(false) }
    val lockLast =  remember { mutableStateOf(false) }
    val gender = remember { mutableStateOf(Gender.MASC) }
    val explicit = remember { mutableStateOf(false) }

    Card (
        shape = RoundedCornerShape(32.dp),
        elevation = 4.dp,
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.primarySurface
    ) {
        WrappedBasicOptionsPanel(
            first = first,
            toggleFirst = { first.value = it },
            lockFirst = lockFirst,
            toggleLockFirst = { lockFirst.value = it },
            last = last,
            toggleLast = { last.value = it },
            lockLast = lockLast,
            toggleLockLast = { lockLast.value = it },
            gender = gender,
            setGender = { gender.value = it  },
            explicit = explicit,
            toggleExplicit = { explicit.value = it }
        )
    }
}