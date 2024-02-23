package com.thirdgallon.namegenerator.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoundedTextButton(text: String, onClick: () -> Unit, enabled: Boolean = true) {
    Button(
        shape = RoundedCornerShape(32.dp),
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        onClick = onClick,
        enabled = enabled,
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 6.dp)
        )
    }
}