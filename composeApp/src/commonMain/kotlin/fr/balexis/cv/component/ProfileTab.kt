package fr.balexis.cv.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.personnal_description_desktop
import balexiscv.composeapp.generated.resources.personnal_description_mobile
import fr.balexis.cv.data.Framework
import fr.balexis.cv.data.listArchi
import fr.balexis.cv.getPlatform
import fr.balexis.cv.theme.LocalAppColors
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource


@Composable
fun ProfileTab() {
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
            .padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.clip(RoundedCornerShape(16.dp))
                .background(LocalAppColors.current.surface).wrapContentSize()
                .padding(vertical = 8.dp, horizontal = 4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LanguageRow()
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    textAlign = TextAlign.Justify,
                    text = stringChoice(),
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontSize = 14.sp
                )
            }
            SoftSkillRow()
            StickyHeaderContent("Mes frameworks", endSpacer = false)
            val horizontalPagerState =
                rememberPagerState(initialPage = 0, pageCount = { Framework.entries.size })
            HorizontalPager(
                modifier = Modifier.fillMaxWidth(),
                state = horizontalPagerState,
            ) { index ->
                val framework = Framework.entries[index]
                Box(
                    modifier = Modifier.wrapContentSize()
                ) {
                    HorizontalPagerIconButtonControl(
                        modifier = Modifier.matchParentSize().zIndex(1f),
                        event = {
                            when (it) {
                                HorizontalPagerDesktopControl.OnLeftButtonClick -> coroutineScope.launch {
                                    horizontalPagerState.animateScrollToPage(
                                        horizontalPagerState.currentPage - 1
                                    )
                                }

                                HorizontalPagerDesktopControl.OnRightButtonClick -> coroutineScope.launch {
                                    horizontalPagerState.animateScrollToPage(
                                        horizontalPagerState.currentPage + 1
                                    )
                                }
                            }
                        },
                        devicePlatform = getPlatform(),
                        horizontalPagerState = HorizontalPagerState(
                            horizontalPagerState.canScrollBackward,
                            horizontalPagerState.canScrollForward
                        )
                    )
                    FrameworkCard(
                        title = framework.title,
                        subtitle = framework.languages,
                        description = framework.view,
                        leadIcon = framework.icon,
                        libraries = framework.libraries,
                        modifier = Modifier.wrapContentHeight().fillMaxWidth(),
                        viewIcon = framework.viewIcon
                    )
                }
            }
            PagerIndicator(horizontalPagerState)
            StickyHeaderContent("Mes langages", endSpacer = false)
            ProgrammingLanguageRow()
            StickyHeaderContent("Patrons architectures", endSpacer = false)
            ArchiRow(list = listArchi)
        }
    }
}


@Composable
private fun stringChoice(): String {
    return when (getPlatform()) {
        "JS" -> stringResource(Res.string.personnal_description_desktop)
        "Android" -> stringResource(Res.string.personnal_description_mobile)
        else -> ""
    }
}


