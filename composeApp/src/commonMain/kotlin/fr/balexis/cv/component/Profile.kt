package fr.balexis.cv.component

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
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import fr.balexis.cv.data.Framework

import fr.balexis.cv.theme.LocalAppColors
import kotlinx.coroutines.launch


@Composable
fun Profile() {
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Column(
                    modifier = Modifier.clip(RoundedCornerShape(16.dp))
                        .background(LocalAppColors.current.surface).fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LanguageRow()
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            textAlign = TextAlign.Justify,
                            text = "Jeune développeur Android ayant pu faire ses armes au cours de mon alternance chez Wimova s'inscrivant dans le cadre de ma 3ème années de BUT Informatique.\n"
                        )
                    }
                    SoftSkillRow(
                        listOf("Adaptabilité", "Autonomie", "Rigeur")
                    )
                }

            }
            item {
                stickyHeaderContentWithoutSpacer("Mes frameworks")
            }
            item {
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
                        HorizontalPagerIconButtonControl(modifier = Modifier.align(Alignment.Center)
                            .fillMaxWidth().padding(horizontal = 4.dp).zIndex(1f), event = {
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
                        })
                        FrameworkCard(
                            title = framework.title,
                            subtitle = framework.langages,
                            description = framework.view,
                            leadIcon = framework.icon,
                            libraries = framework.libraries,
                            modifier = Modifier.fillMaxWidth().align(Alignment.Center)
                                .height(200.dp),
                            viewIcon = framework.viewIcon
                        )

                    }

                }
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
            item {
                stickyHeaderContentWithoutSpacer("Mes langages")
            }
            item {
                Row {
                    ProgrammingLanguageRow(
                        modifier = Modifier.weight(1f)
                    )
                    Column(
                        modifier = Modifier.wrapContentSize()
                    ) {
                        Card {
                            Row {
                                Column {
                                    Text("Clean architecture")
                                }
                                Column {
                                    Text("Pattern")
                                    listArchi.forEach {
                                        Text(it)
                                    }

                                }
                            }

                        }
                    }
                }
            }
            item {
                stickyHeaderContentWithoutSpacer("Mes outils")
            }
            item {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(128.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
                        .height(100.dp)
                ) {
                    items(i) {
                        Column(
                            modifier = Modifier.wrapContentSize().clip(RoundedCornerShape(16.dp))
                                .background(LocalAppColors.current.surface)
                                .border(1.dp, Color.Black, RoundedCornerShape(16.dp)).padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                modifier = Modifier.size(32.dp)
                            )
                            Text(it)
                        }
                    }
                }
            }
            item {
                Spacer(
                    modifier = Modifier.height(50.dp)
                )
            }

        }
    }

}


val i = listOf("GIT", "Bitrise", "Agile", "Trello")
val listArchi = listOf("MVVM", "MVC", "MVI")
