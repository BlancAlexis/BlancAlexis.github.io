package fr.balexis.cv

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.compose_multiplatform
import fr.balexis.cv.g.Item
import fr.balexis.cv.g.ItemUiState
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

val listSchool = listOf(
    schoolTraining(
        "BUT Informatique", "IUT Lyon 1 - Bourg-en-Bresse", "2021 - 2024"
    ),
    schoolTraining(
        "Baccalauréat", "Lycée carriat - Bourg-en-Bresse", "2018 - 2021"
    ),
)

//val listMentoredProject = listOf(
//    ItemUiState(
//
//)
val list = (1..10).map {
    ItemUiState(
        "Wimomerde $it",
        " Alternant dev mobile",
        "Septembre 2023 - 2024",
        "Développements de nouvelles fonctionnalités\n" + "Corrections de bugs \n" + "Mise en place d’architecture logicielle \n" + "Intégré en équipe suivant une méthode Agile\n" + "Test unitaire",
        listOf("Kotlin", "Java", "Android", "Kotlin", "Java", "Android")
    )
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
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
                    modifier = Modifier.fillMaxSize().background(Color.Green),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box(
                        modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.Center
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.widthIn(50.dp, 150.dp).fillMaxWidth().shadow(
                                25.dp, shape = RoundedCornerShape(
                                    bottomStart = 32.dp, bottomEnd = 32.dp
                                )
                            ).align(Alignment.TopEnd),
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            IconButton(onClick = {
                                uriHandler.openUri("https://www.linkedin.com/in/alexis--blanc/")

                            }

                            ) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    painter = painterResource(Res.drawable.compose_multiplatform),
                                    contentDescription = null

                                )
                            }
                            IconButton(onClick = {
                                navController.navigate(Routes.AboutPage)
                            }

                            ) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    painter = painterResource(Res.drawable.compose_multiplatform),
                                    contentDescription = null

                                )
                            }
                            IconButton(onClick = {
                                navController.navigate(Routes.AboutPage)
                            }

                            ) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    painter = painterResource(Res.drawable.compose_multiplatform),
                                    contentDescription = null

                                )
                            }
                        }
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
                                text = "BLANC Alexis", modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }

                    Surface(
                        modifier = Modifier.weight(1f).fillMaxWidth(),
                        color = Color.Blue,
                        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                    ) {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            item(

                            ) {
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

                            items(list.take(3)) { exp ->
                                Item(exp)
                            }
                            item {
                                experienceDivider()
                            }
                            stickyHeader {
                                stickyHeaderContent(
                                    text = "Projets personnels"
                                )
                            }
                            items(list) { exp ->
                                Item(exp)
                            }
                            item {
                                experienceDivider()
                            }
                            stickyHeader {
                                stickyHeaderContent(
                                    text = "Projets tutorés"
                                )
                            }
                            items(list) { exp ->
                                Item(exp)
                            }
                            stickyHeader {
                                stickyHeaderContent(
                                    text = "Formation"
                                )
                            }
                            items(listSchool) { exp ->
                                TrainingItem(exp)
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

@Composable
private fun experienceDivider() {
    Divider(
        color = Color.Black,
        thickness = 1.dp,
        modifier = Modifier.widthIn(100.dp, 300.dp).fillMaxWidth(0.6f)
    )
}

@Composable
fun stickyHeaderContent(
    text: String
) {
    Row(
        modifier = Modifier.drawBehind {
            drawRect(Color.Blue, size = size.copy(height = size.height / 2))
        }.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(Color.Magenta),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text)
    }
}

data class schoolTraining(
    val title: String, val description: String, val date: String
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TrainingItem(exp: schoolTraining) {
    Card(

    ) {
        ListItem(text = {
            Text(exp.title)
        }, icon = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.List, contentDescription = null
            )
        }, secondaryText = {
            Text(exp.description)
        }, trailing = {
            Text(exp.date)
        })
    }
}

data class project(
    val title: String, val description: String, val date: String, val listlib: List<String>
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProjectItem(exp: project) {
    Card(

    ) {
        ListItem(text = {
            Text(exp.title)
        }, secondaryText = {
            Text(exp.description)
        }, icon = {
            Icon(
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null
            )
        }, trailing = {
            Text(exp.date)
        })
    }
}

sealed interface Routes {
    @kotlinx.serialization.Serializable
    data object MainPage : Routes

    @kotlinx.serialization.Serializable
    data object AboutPage : Routes

    @Serializable
    data object ContactPage : Routes
}