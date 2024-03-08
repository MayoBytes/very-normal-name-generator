package com.thirdgallon.namegenerator.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thirdgallon.namegenerator.database.SavedName

@Composable
fun SavedNameListItem(
    savedName: SavedName,
    onClick: (savedName: SavedName) -> Unit,
    onDelete: (savedName: SavedName) -> Unit,
) {

    Card(
        modifier = Modifier.padding(0.dp, 1.dp)
    ) {
        Row(
            //modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextButton(
                modifier = Modifier.fillMaxWidth(0.8f),
                onClick = { onClick(savedName) },

            ) {
                Text(
                    textAlign = TextAlign.Start,
                    text = savedName.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
            }
            IconButton(
                onClick = { onDelete(savedName) },
                modifier = Modifier.padding(8.dp),
            ) {
                Icon(Icons.Rounded.Delete, "delete", tint = MaterialTheme.colors.error)
            }
        }
    }
}