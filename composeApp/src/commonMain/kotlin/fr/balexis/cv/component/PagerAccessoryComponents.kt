@file:OptIn(ExperimentalLayoutApi::class)

package fr.balexis.cv.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.balexis.cv.theme.LocalAppColors

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
                    modifier = Modifier.fillMaxSize(0.8f),
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
fun PagerIndicator(horizontalPagerState: PagerState) {
    Row(
        Modifier.wrapContentHeight().fillMaxWidth().padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(horizontalPagerState.pageCount) { iteration ->
            val color =
                if (horizontalPagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier.padding(2.dp).clip(CircleShape).background(color)
                    .size(8.dp)
            )
        }
    }
}





