package fr.balexis.cv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import fr.balexis.cv.component.ExperienceListTab
import fr.balexis.cv.component.MainScreenEvent
import fr.balexis.cv.component.MediaItems
import fr.balexis.cv.component.ProfessionalMediaCap
import fr.balexis.cv.component.ProfileHeader
import fr.balexis.cv.component.ProfileTab
import fr.balexis.cv.theme.LocalAppColors
import kotlinx.coroutines.launch

const val MAX_SCREEN_WIDTH = 1200
const val DEFAULT_MAX_ITEM = 2

@Composable
fun MainPage(
    onEvent: (MainScreenEvent) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val uriHandler = LocalUriHandler.current
    val pagerState =
        rememberPagerState(initialPage = 0, pageCount = { MainScreenTabs.entries.size })
    val tabSelectedIndex by remember { derivedStateOf { pagerState.currentPage } }
    Column(
        modifier = Modifier.fillMaxSize().background(LocalAppColors.current.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.Center
        ) {
            ProfessionalMediaCap(modifier = Modifier.align(Alignment.TopCenter),
                onEvent = {
                    when (it) {
                        is MediaItems.Linkedin -> {
                            uriHandler.openUri("https://www.linkedin.com/in/alexis--blanc/")
                        }

                        is MediaItems.Github -> {
                            uriHandler.openUri("https://github.com/BlancAlexis")

                        }

                        is MediaItems.Mail -> {
                            uriHandler.openUri("mailto:blanc.alexispro@gmail.com")
                        }

                        MediaItems.Contact -> {
                            onEvent(MainScreenEvent.OpenContactDialog)
                        }
                    }
                })
            ProfileHeader()
        }
        Surface(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            color = LocalAppColors.current.background,
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TabRow(
                    modifier = Modifier.wrapContentSize().widthIn(max = MAX_SCREEN_WIDTH.dp),
                    selectedTabIndex = tabSelectedIndex,
                    backgroundColor = LocalAppColors.current.background,
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            color = LocalAppColors.current.primary,
                            modifier = Modifier.tabIndicatorOffset(tabPositions[tabSelectedIndex])
                        )
                    },
                ) {
                    MainScreenTabs.entries.forEach { tab ->
                        val isSelected = tabSelectedIndex == tab.ordinal
                        Tab(text = {
                            Text(
                                text = tab.text,
                                color = if (isSelected) LocalAppColors.current.primary else LocalAppColors.current.surface,
                            )
                        }, icon = {
                            Icon(
                                tint = if (isSelected) LocalAppColors.current.primary else LocalAppColors.current.surface,
                                imageVector = if (isSelected) tab.selectedIcon else tab.unselectedIcon,
                                contentDescription = tab.text
                            )
                        }, selected = isSelected, onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(tab.ordinal)
                            }
                        })
                    }
                }
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.wrapContentSize().widthIn(max = MAX_SCREEN_WIDTH.dp)
                        .padding(horizontal = 8.dp),
                ) { page ->
                    when (page) {
                        0 -> {
                            ProfileTab()
                        }

                        1 -> {
                            ExperienceListTab()
                        }
                    }
                }
            }
        }
    }
}


enum class MainScreenTabs(
    val selectedIcon: ImageVector, val unselectedIcon: ImageVector, val text: String
) {
    Profile(
        unselectedIcon = Icons.Outlined.Person, selectedIcon = Icons.Filled.Person, text = "Profil"
    ),
    Experience(
        unselectedIcon = Icons.Outlined.Star, selectedIcon = Icons.Filled.Star, text = "Experience"
    ),

}






