package fr.balexis.cv.data

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Chip
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.android
import fr.balexis.cv.model.FullItemData
import org.jetbrains.compose.resources.painterResource

val topShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
val bottomShape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)

@Composable
fun CustomListItem(
    itemUiState: FullItemData
) {
    var isOpen by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = 2.dp,
    ) {
        Column {
            Column(
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(28.dp),
                        tint = Color.Unspecified,
                        painter = painterResource(Res.drawable.android),
                        contentDescription = null
                    )
                    Text(itemUiState.title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text(
                        itemUiState.date, style = TextStyle(
                            color = Color.Gray,
                            fontSize = 10.sp,
                            letterSpacing = 0.1.sp,
                            lineHeight = 16.sp,
                            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif
                        )
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(itemUiState.companyName)
                    IconButton(onClick = {
                        isOpen = !isOpen
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null
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


            }
            KeySkillsRow(itemUiState)
        }
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun KeySkillsRow(itemUiState: FullItemData) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemUiState.tags) { skill ->
            Chip(onClick = {

            }, content = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null
                )
                Text(skill)
            })
        }
    }
}

@Composable
fun BackgroundWrapper(
    shape: Shape,
    color: Color = Color(0xFF93E9BE),
    content: @Composable () -> Unit
) {
    Card(
        shape = shape,
        backgroundColor = color,
    ) {
        content()
    }
}