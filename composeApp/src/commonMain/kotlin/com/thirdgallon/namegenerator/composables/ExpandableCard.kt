package com.thirdgallon.namegenerator.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ExpandableCard(text: String, content: @Composable () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Card (
        shape = RoundedCornerShape(32.dp),
        elevation = 4.dp,
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.primarySurface
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            TextButton(
                onClick = { expanded = !expanded },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = text,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 24.sp,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            AnimatedVisibility(expanded) {
                content()
            }
        }
    }

}