package fr.balexis.cv

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.istockphoto_1090878494_612x612
import fr.balexis.cv.component.CustomDivider
import fr.balexis.cv.component.LazyColumnCategory
import fr.balexis.cv.component.ProfessionalMediaCap
import fr.balexis.cv.component.SocialNav
import fr.balexis.cv.component.TrainingItem
import fr.balexis.cv.component.stickyHeaderContent
import fr.balexis.cv.data.BackgroundWrapper
import fr.balexis.cv.data.CustomListItem
import fr.balexis.cv.data.listMentoredProject
import fr.balexis.cv.data.listPersonalProject
import fr.balexis.cv.data.listProfesionalExperience
import fr.balexis.cv.data.listSchool
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

const val MAX_SCREEN_WIDTH = 1200
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainPage(
    onEvent: (MainScreenEvent) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val uriHandler = LocalUriHandler.current
    var nextItem by remember { mutableStateOf(2) }
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })
    val tabSelectedIndex by remember { derivedStateOf { pagerState.currentPage } }
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFF1F2F6)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.Center
        ) {
            ProfessionalMediaCap(modifier = Modifier.align(Alignment.TopCenter),
                onEvent = {
                    when (it) {
                        is SocialNav.Linkedin -> {
                            uriHandler.openUri("https://www.linkedin.com/in/alexis--blanc/")
                        }

                        is SocialNav.Github -> {
                            onEvent(MainScreenEvent.openContactDialog)
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
            color = Color(0xFF00888F),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TabRow(
                    modifier = Modifier.wrapContentSize().widthIn(max = MAX_SCREEN_WIDTH.dp),
                    selectedTabIndex = tabSelectedIndex,
                    backgroundColor = Color(0xFF00888F),
                    /* indicator = { tabPositions ->
                         TabRowDefaults.Indicator(
                             color = Color.Red,
                             modifier = Modifier.tabIndicatorOffset(tabPositions[tabSelectedIndex])
                         )
                     },*/
                ) {

                    MainScreenTabs.entries.forEach { tab ->
                        Tab(text = { Text(text = tab.text) }, icon = {
                            Icon(
                                imageVector = if (tabSelectedIndex == tab.ordinal) tab.selectedIcon else tab.unselectedIcon,
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
                        .padding(horizontal = 16.dp),

                    ) { page ->
                    when (page) {
                        0 -> {
                            ExperienceList(nextItem)
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

sealed interface MainScreenEvent {
    object openContactDialog : MainScreenEvent
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

@Composable
fun Profile() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Profile")
    }
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun ExperienceList(nextItem: Int) {
    var nextItem1 = nextItem
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Jeune développeur Android ayant pu faire ses armes au cours de mon alternance chez Wimova s'inscrivant dans le cadre de ma 3ème années de BUT Informatique.\n"
                )
            }
        }
        //filter
        stickyHeader {
            stickyHeaderContent(
                text = "Expérience"
            )
        }

        itemsIndexed(listProfesionalExperience.take(nextItem1),
            key = { _, item -> item.hashCode() }) { index, exp ->
            LazyColumnCategory(listProfesionalExperience.size, index) { shape ->
                BackgroundWrapper(shape = shape, content = { CustomListItem(exp) })
            }
        }
        if (listProfesionalExperience.size > 2) {
            item {
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                        .padding(bottom = 8.dp).clip(
                            RoundedCornerShape(
                                bottomStart = 16.dp, bottomEnd = 16.dp
                            )
                        ).background(Color(0xFF3C91E6)).clickable {
                            nextItem1 = if (nextItem1 < listProfesionalExperience.size) {
                                listProfesionalExperience.size
                            } else {
                                2
                            }
                        }

                ) {
                    Icon(
                        imageVector = if (nextItem1 == 2) {
                            Icons.Default.ArrowDropDown
                        } else {
                            Icons.Default.KeyboardArrowUp
                        }, contentDescription = null
                    )
                }
            }
        }

        stickyHeader {
            stickyHeaderContent(
                text = "Projets personnels"
            )
        }
        itemsIndexed(listPersonalProject, key = { _, item -> item.hashCode() }) { index, exp ->
            LazyColumnCategory(
                listPersonalProject.size, index
            ) { shape ->
                BackgroundWrapper(shape) {
                    CustomListItem(exp)
                }
            }
        }
        item {
            CustomDivider()
        }
        stickyHeader {
            stickyHeaderContent(
                text = "Projets tutorés"
            )
        }
        itemsIndexed(listMentoredProject, key = { _, item -> item.hashCode() }) { index, exp ->
            LazyColumnCategory(
                listMentoredProject.size, index
            ) { shape ->
                BackgroundWrapper(shape) {
                    CustomListItem(exp)
                }
            }
        }
        item {
            CustomDivider()
        }
        stickyHeader {
            stickyHeaderContent(
                text = "Formation"
            )
        }
        itemsIndexed(listSchool, key = { _, item -> item.hashCode() }) { index, exp ->
            LazyColumnCategory(listSchool.size, index) { shape ->
                BackgroundWrapper(shape) {
                    TrainingItem(exp)
                }
            }
        }
    }
}

@Composable
private fun ProfileHeader() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 3.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(Res.drawable.istockphoto_1090878494_612x612),
            modifier = Modifier.widthIn(max = 150.dp),
            contentDescription = null,
        )
        Text(
            maxLines = 1,
            text = "BLANC Alexis",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.weight(1F).padding(start = 16.dp).offset(x = -(8).dp).align(Alignment.Bottom)
        )
    }
}