package com.thirdgallon.namegenerator.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PinnableToggle(
    text: String,
    enabled: State<Boolean>,
    onToggle: () -> Unit,
    pinned: State<Boolean>,
    onPinToggle: () -> Unit,
) {

    Row (
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier.padding(0.dp, 0.dp, 1.dp, 0.dp),
            border = if (!enabled.value)
                BorderStroke(2.dp, MaterialTheme.colors.onPrimary)
            else null,
            onClick = onToggle,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (enabled.value) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primary,
            )
        ) {
            Text(text)
        }
        AnimatedVisibility(enabled.value) {
            IconButton(
                modifier = Modifier.padding(1.dp, 0.dp, 0.dp, 0.dp),
                onClick = onPinToggle,
            ) {
                Icon(
                    if (pinned.value)
                        Icons.Filled.Lock
                    else
                        Icons.Filled.LockOpen,
                    modifier = Modifier.size(20.dp).padding(0.dp),
                    contentDescription = null,
                )
            }
        }
    }
}