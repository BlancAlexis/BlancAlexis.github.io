package fr.balexis.cv.g

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Chip
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class ItemUiState(
    val companyName: String, val job: String, val date: String, val description: String, val skills: List<String>
)

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterialApi::class)
@Composable
fun Item(
  itemUiState: ItemUiState
) {
    var isOpen by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(itemUiState.job)
                Text(
                    itemUiState.date, style = TextStyle(
                        color = androidx.compose.ui.graphics.Color.Gray,
                        fontSize = 12.sp,
                        letterSpacing = 0.5.sp,
                        lineHeight = 16.sp,
                        fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif
                    )
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(itemUiState.companyName)
                IconButton(onClick = {
                    isOpen = !isOpen
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward, contentDescription = null
                    )
                }
            }
            AnimatedVisibility(
                isOpen
            ) {
                Text(
                    itemUiState.description, modifier = Modifier.padding(16.dp)
                )

            }
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(itemUiState.skills){ skill ->
                    Chip(onClick = {

                    }, content = {
                        Text(skill)
                    })
                }
            }

        }
    }
}