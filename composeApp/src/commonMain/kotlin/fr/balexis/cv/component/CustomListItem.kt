package fr.balexis.cv.data

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.compose_multiplatform
import fr.balexis.cv.model.FullItemData
import fr.balexis.cv.theme.LocalAppColors
import fr.balexis.cv.theme.columbiaBlue
import fr.balexis.cv.theme.pearl
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

val topShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
val bottomShape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)


@Preview
@Composable
fun CustomListItem(
    itemUiState: FullItemData
) {
    var isOpen by remember { mutableStateOf(false) }
    Card(
        backgroundColor = LocalAppColors.current.secondary,
        modifier = Modifier.fillMaxWidth().padding(8.dp), elevation = 4.dp
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)
            ) {
                Icon(
                    tint = Color.Unspecified,
                    modifier = Modifier.size(50.dp).fillMaxHeight().align(Alignment.CenterVertically).padding(horizontal = 4.dp),
                    painter = if(itemUiState.mainIcon != null){ painterResource(itemUiState.mainIcon)} else {painterResource(Res.drawable.compose_multiplatform)},
                    contentDescription = null
                )

                Column(
                    modifier = Modifier.weight(1f).padding(top = 8.dp, start = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        itemUiState.title,
                        modifier = Modifier.horizontalScroll(rememberScrollState()),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Clip
                    )

                    Text(
                        text = itemUiState.companyName
                    )
                    Text(
                        itemUiState.date, style = TextStyle(
                            color = Color.Gray,
                            fontSize = 10.sp,
                            letterSpacing = 0.1.sp,
                            lineHeight = 16.sp,
                            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif
                        ), modifier = Modifier.padding(top = 8.dp, end = 8.dp)
                    )
                }
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    IconButton(onClick = {
                        isOpen = !isOpen
                    }) {
                        Icon(
                            imageVector = if (!isOpen) {
                                Icons.Filled.ArrowDropDown
                            } else {
                                Icons.Filled.KeyboardArrowUp
                            },
                            contentDescription = null
                        )
                    }
                }
            }
            AnimatedVisibility(
                isOpen
            ) {
                Text(
                    itemUiState.description, modifier = Modifier.padding(16.dp)
                )
            }
            KeySkillsRow(
                itemUiState.tags
            )
        }
    }
}


@Composable
@OptIn(ExperimentalMaterialApi::class)
 fun KeySkillsRow(itemUiState: List<String>, autoScroll : Boolean = false) {
    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemUiState) { skill ->
            Chip(colors = ChipDefaults.chipColors(backgroundColor = pearl), onClick = {

            }, content = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null
                )
                Text(skill)
            })
        }
    }
}

@Composable
fun BackgroundWrapper(
    shape: Shape, color: Color = LocalAppColors.current.surface, content: @Composable () -> Unit
) {
    Card(
        shape = shape,
        backgroundColor = color,
    ) {
        content()
    }
}