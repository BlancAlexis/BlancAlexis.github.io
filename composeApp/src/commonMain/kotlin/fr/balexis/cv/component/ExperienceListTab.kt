package fr.balexis.cv.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.unit.dp
import fr.balexis.cv.DEFAULT_MAX_ITEM
import fr.balexis.cv.data.BackgroundWrapper
import fr.balexis.cv.data.CustomListItem
import fr.balexis.cv.data.listMentoredProject
import fr.balexis.cv.data.listPersonalProject
import fr.balexis.cv.data.listProfessionalExperience
import fr.balexis.cv.data.listSchool
import fr.balexis.cv.theme.LocalAppColors


@Composable
@OptIn(ExperimentalFoundationApi::class)
fun ExperienceListTab(
    uriHandler: UriHandler
) {
    var maxItemsLazyRowProXP by remember { mutableStateOf(DEFAULT_MAX_ITEM) }
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(vertical = 8.dp),
    ) {
        stickyHeader {
            StickyHeaderContent(
                text = "Expérience"
            )
        }

        itemsIndexed(listProfessionalExperience.take(maxItemsLazyRowProXP),
            key = { _, item -> item.hashCode() }) { index, exp ->
            LazyColumnCategory(listProfessionalExperience.size, index) { shape ->
                BackgroundWrapper(
                    modifier = Modifier.animateItem(),
                    shape = if (index != listProfessionalExperience.size - 1) {
                        shape
                    } else {
                        RectangleShape
                    }
                ) {
                    CustomListItem(itemUiState = exp, modifier = Modifier.animateItem())

                }
            }
        }
        if (listProfessionalExperience.size > 2) {
            item {
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()

                        .padding(bottom = 8.dp).clip(
                            RoundedCornerShape(
                                bottomStart = 16.dp, bottomEnd = 16.dp
                            )
                        ).background(LocalAppColors.current.surface).clickable {
                            maxItemsLazyRowProXP =
                                if (maxItemsLazyRowProXP < listProfessionalExperience.size) {
                                    listProfessionalExperience.size
                                } else {
                                    2
                                }
                        }

                ) {
                    Icon(
                        imageVector = if (maxItemsLazyRowProXP == 2) {
                            Icons.Default.ArrowDropDown
                        } else {
                            Icons.Default.KeyboardArrowUp
                        }, contentDescription = null
                    )
                }
            }
        }
        stickyHeader {
            StickyHeaderContent(
                text = "Projets personnels"
            )
        }
        itemsIndexed(listPersonalProject, key = { _, item -> item.hashCode() }) { index, exp ->
            LazyColumnCategory(
                listPersonalProject.size, index
            ) { shape ->
                BackgroundWrapper(
                    shape = shape, content = {
                        CustomListItem(exp, Modifier.animateItem(), onEvent = {
                            uriHandler.openUri(it)
                        }
                        )
                    }, modifier = Modifier.animateItem()
                )
            }
        }
        item {
            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }
        stickyHeader {
            StickyHeaderContent(
                text = "Projets tutorés"
            )
        }
        itemsIndexed(listMentoredProject, key = { _, item -> item.hashCode() }) { index, exp ->
            LazyColumnCategory(
                listMentoredProject.size, index
            ) { shape ->
                BackgroundWrapper(
                    shape = shape, content = {
                        CustomListItem(exp, Modifier.animateItem())
                    }, modifier = Modifier.animateItem()
                )
            }
        }
        item {
            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }
        stickyHeader {
            StickyHeaderContent(
                text = "Formation"
            )
        }
        itemsIndexed(listSchool, key = { _, item -> item.hashCode() }) { index, exp ->
            LazyColumnCategory(listSchool.size, index) { shape ->
                BackgroundWrapper(shape = shape, content = {
                    TrainingItem(exp)
                }, modifier = Modifier.animateItem())
            }
        }
    }
}