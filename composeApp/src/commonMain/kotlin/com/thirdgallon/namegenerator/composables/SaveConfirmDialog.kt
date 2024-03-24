package com.thirdgallon.namegenerator.composables

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun SaveConfirmDialog(
    visible: MutableState<Boolean>,
    name: String,
    onDismiss: () -> Unit,
    onSave: (String?) -> Unit,
    ) {

    if (visible.value) {
        AlertDialog(
            title = { Text("Really?") },
            text = { Text("Is $name THAT important to you?") },
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(onClick = {
                    onSave(null)
                    onDismiss()
                }) {
                    Text("Save Name")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text("Dismiss")
                }
            }
        )
    }
}