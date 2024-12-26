package fr.balexis.cv

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import fr.balexis.cv.component.ExperienceList
import fr.balexis.cv.component.FrameworkCard
import fr.balexis.cv.component.HorizontalPagerDesktopControl
import fr.balexis.cv.component.HorizontalPagerIconButtonControl
import fr.balexis.cv.component.LanguageRow
import fr.balexis.cv.component.MainScreenEvent
import fr.balexis.cv.component.ProfessionalMediaCap
import fr.balexis.cv.component.Profile
import fr.balexis.cv.component.ProfileHeader
import fr.balexis.cv.component.ProgrammingLanguageRow
import fr.balexis.cv.component.SocialNav
import fr.balexis.cv.component.SoftSkillRow
import fr.balexis.cv.component.stickyHeaderContentWithoutSpacer
import fr.balexis.cv.data.Framework
import fr.balexis.cv.theme.LocalAppColors
import kotlinx.coroutines.launch

const val MAX_SCREEN_WIDTH = 1200
val DEFAULT_MAX_ITEM = 2

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
            ProfessionalMediaCap(modifier = Modifier.align(Alignment.TopCenter), onEvent = {
                when (it) {
                    is SocialNav.Linkedin -> {
                        uriHandler.openUri("https://www.linkedin.com/in/alexis--blanc/")
                    }

                    is SocialNav.Github -> {
                        onEvent(MainScreenEvent.OpenContactDialog)
                    }

                    is SocialNav.Mail -> {
                        uriHandler.openUri("mailto:blanc.alexispro@gmail.com")
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
                        }, selected = tabSelectedIndex == tab.ordinal, onClick = {
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
                            ExperienceList()
                        }

                        1 -> {
                            Profile()
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
    Experience(
        unselectedIcon = Icons.Outlined.Star, selectedIcon = Icons.Filled.Star, text = "Experience"
    ),
    Profile(
        unselectedIcon = Icons.Outlined.Person, selectedIcon = Icons.Filled.Person, text = "Profile"
    )
}



