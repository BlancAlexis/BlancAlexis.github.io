package fr.balexis.cv

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DrawerDefaults.shape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.compose_multiplatform
import fr.balexis.cv.component.ExperienceDivider
import fr.balexis.cv.component.LazyColumnCategory
import fr.balexis.cv.component.ProfessionalMediaCap
import fr.balexis.cv.component.SocialNav
import fr.balexis.cv.component.TrainingItem
import fr.balexis.cv.component.stickyHeaderContent
import fr.balexis.cv.data.Item
import fr.balexis.cv.data.listMentoredProject
import fr.balexis.cv.data.listPersonalProject
import fr.balexis.cv.data.listProfesionalExperience
import fr.balexis.cv.data.listSchool
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun App() {
    val uriHandler = LocalUriHandler.current

    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Routes.MainPage,
        ) {
            composable<Routes.MainPage> {

                Column(
                    modifier = Modifier.fillMaxSize().background(Color(0xFFF1F2F6)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box(
                        modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.Center
                    ) {
                        ProfessionalMediaCap(modifier = Modifier.align(Alignment.TopCenter),//Ignoble
                            onEvent = {
                                when (it) {
                                    is SocialNav.Linkedin -> {
                                        uriHandler.openUri("https://www.linkedin.com/in/alexis--blanc/")
                                    }

                                    is SocialNav.Github -> {
                                        navController.navigate(Routes.AboutPage)
                                    }

                                    is SocialNav.Mail -> {
                                        uriHandler.openUri("mailto:william.paterson@my-own-personal-domain.com")
                                    }
                                }
                            })
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.compose_multiplatform),
                                modifier = Modifier.widthIn(max = 150.dp),
                                contentDescription = null,
                            )
                            Text(
                                text = "BLANC Alexis",
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.padding(start = 16.dp).align(Alignment.Bottom)
                            )
                        }
                    }

                    Surface(
                        modifier = Modifier.weight(1f).fillMaxWidth(),
                        color = Color(0xFF00888F),
                        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                    ) {
                        LazyColumn(
                            modifier = Modifier
                                .wrapContentSize()
                                .widthIn(max = 1000.dp)
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
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

                            itemsIndexed(
                                listProfesionalExperience.take(3),
                                key = { _, item -> item.hashCode() }) { index, exp ->
                                LazyColumnCategory(listProfesionalExperience.size, index) { shape ->
                                    Item(shape, exp)

                                }
                            }
                            item {
                                ExperienceDivider()
                            }
                            stickyHeader {
                                stickyHeaderContent(
                                    text = "Projets personnels"
                                )
                            }
                            itemsIndexed(
                                listPersonalProject,
                                key = { _, item -> item.hashCode() }) { index, exp ->
                                LazyColumnCategory(listPersonalProject.size, index) { shape ->
                                    Item(shape, exp)
                                }
                            }
                            item {
                                ExperienceDivider()
                            }
                            stickyHeader {
                                stickyHeaderContent(
                                    text = "Projets tutorés"
                                )
                            }
                            itemsIndexed(
                                listMentoredProject,
                                key = { _, item -> item.hashCode() }) { index, exp ->
                                LazyColumnCategory(listMentoredProject.size, index) { shape ->
                                    Item(shape, exp)
                                }
                            }
                            item {
                                ExperienceDivider()
                            }
                            stickyHeader {
                                stickyHeaderContent(
                                    text = "Formation"
                                )
                            }
                            itemsIndexed(
                                listSchool,
                                key = { _, item -> item.hashCode() }) { index, exp ->
                                LazyColumnCategory(listSchool.size, index) { shape ->
                                    TrainingItem(exp, shape)

                                }
                            }
                        }
                    }

                }

            }
            composable<Routes.AboutPage> {

            }
            composable<Routes.ContactPage> {

            }
        }
    }
}

sealed interface Routes {
    @Serializable
    data object MainPage : Routes

    @Serializable
    data object AboutPage : Routes

    @Serializable
    data object ContactPage : Routes
}