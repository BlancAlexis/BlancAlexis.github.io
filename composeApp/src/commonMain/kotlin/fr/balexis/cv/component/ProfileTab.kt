@file:OptIn(ExperimentalLayoutApi::class)

package fr.balexis.cv.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.balexis.cv.theme.LocalAppColors
import fr.balexis.cv.theme.vistaBlue
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

data class HorizontalPagerState(
    val leftButton: Boolean, val rightButton: Boolean
)

@Composable
fun HorizontalPagerIconButtonControl(
    modifier: Modifier,
    event: (HorizontalPagerDesktopControl) -> Unit,
    devicePlatform: String,
    horizontalPagerState: HorizontalPagerState
) {
    if (devicePlatform == "JS") {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.then(Modifier.fillMaxWidth()),
        ) {
            AnimatedVisibility(horizontalPagerState.leftButton) {
                Column(
                    modifier = Modifier.fillMaxSize(0.8f).padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    IconButton(
                        onClick = { event(HorizontalPagerDesktopControl.OnLeftButtonClick) },
                        modifier = Modifier.clip(CircleShape)
                            .background(Color.Black.copy(alpha = 0.2f))
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = LocalAppColors.current.onBackground
                        )
                    }
                }

            }
            AnimatedVisibility(horizontalPagerState.rightButton) {
                Column(
                    modifier = Modifier.fillMaxSize(0.8f),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    IconButton(
                        onClick = { event(HorizontalPagerDesktopControl.OnRightButtonClick) },
                        modifier = Modifier.clip(CircleShape)
                            .background(Color.Black.copy(alpha = 0.2f))
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = LocalAppColors.current.onBackground
                        )
                    }
                }
            }
        }
    }
}

sealed class HorizontalPagerDesktopControl {
    data object OnLeftButtonClick : HorizontalPagerDesktopControl()
    data object OnRightButtonClick : HorizontalPagerDesktopControl()
}

@Composable
fun FrameworkCard(
    title: String,
    subtitle: String,
    description: String,
    leadIcon: DrawableResource,
    viewIcon: DrawableResource,
    libraries: List<String>,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.border(1.dp, Color.Black, RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier.wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                contentScale = ContentScale.FillWidth,
                painter = painterResource(leadIcon),
                contentDescription = null,
                modifier = Modifier.size(80.dp).fillMaxWidth(0.2f).padding(horizontal = 8.dp)
            )
            Column(
                modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(16.dp))
                    .background(LocalAppColors.current.secondary)
                    .border(1.dp, Color.Black, RoundedCornerShape(16.dp)).padding(8.dp),

                ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
                IconTextRow(subtitle, icon = Icons.Default.Build)
                IconTextRow(description, icon = viewIcon)
                CustomDivider(0.8f)
                LibraryKnow(
                    libs = libraries
                )
            }
        }
    }
}

@Composable
private fun IconTextRow(text: String, icon: ImageVector) {
    Row(
        modifier = Modifier.wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon, modifier = Modifier.size(24.dp), contentDescription = null
        )
        Text(
            text = text, modifier = Modifier.padding(start = 8.dp),
        )
    }

}

@Composable
private fun IconTextRow(text: String, icon: DrawableResource) {
    Row(
        modifier = Modifier.wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            tint = Color.Unspecified,
            painter = painterResource(icon),
            modifier = Modifier.size(24.dp),
            contentDescription = null
        )
        Text(
            text = text, modifier = Modifier.padding(start = 8.dp)
        )
    }

}


@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun LibraryKnow(
    libs: List<String>
) {
    var maxLines by remember {
        mutableIntStateOf(1)
    }
    var remainingItems = 0
    ContextualFlowRow(
        modifier = Modifier.fillMaxWidth().wrapContentHeight().animateContentSize(),
        maxLines = maxLines,
        itemCount = libs.size,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        overflow = ContextualFlowRowOverflow.expandOrCollapseIndicator(
            expandIndicator = {
                Chip(
                    content = { Text("+$remainingItems") },
                    onClick = { maxLines = 4 },
                    modifier = Modifier.wrapContentSize(),
                    colors = ChipDefaults.chipColors(backgroundColor = vistaBlue)
                )
            },
            collapseIndicator = {
                Chip(
                    content = { Text("Restreindre") },
                    onClick = { maxLines = 1 },
                    modifier = Modifier.wrapContentSize(),
                    colors = ChipDefaults.chipColors(backgroundColor = vistaBlue)
                )
            }
        ),
    ) { index ->
        remainingItems = libs.size - index
        Chip(content = { Text(libs[index], fontSize = 12.sp) }, onClick = {})
    }
}


