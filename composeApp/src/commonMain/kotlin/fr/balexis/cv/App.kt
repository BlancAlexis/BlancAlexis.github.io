package fr.balexis.cv

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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.compose_multiplatform
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

data class Person(
    val name: String, val age: Int
)

val list = (1..10).map {
    Person("Person $it", it)
}

@Composable
@Preview
fun App() {
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
                        LazyColumn {
                            item {
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        "Jeune développeur Android ayant pu faire ses armes au cours de mon alternance chez Wimova s'inscrivant dans le cadre de ma 3ème années de BUT Informatique.\n" + "\n" + "Durant cette années j'ai eu la chance de m'intégrer dans une équipe SCRUM afin de mener à bien les différents projets de l'entreprise.\n" + "\n" + "J'ai notamment pu travailler sur l'application MEWI Driver Android qui est actuellement en production, mon travail à aussi bien été du bugfixe que du développement de nouvelles fonctionnalités, essentiellement en Java et XML, mais avec du Kotlin pour les nouvelles fonctionnalités.\n" + "\n" + "Mais également travailler sur une application en développement, utilisant Kotlin et Compose pour les écrans de l'application. Grâce à celle-ci j'ai eu l'occasion de faire de la conception, mettre en place des architectures MVVM + Clean archi pour de nouvelle fonctionnalités, ainsi que refactor du code pour traiter des bugs.\n" + "\n" + "\n" + "En terme d'API que je maitrise : \n" + "- Compose\n" + "- Volley\n" + "- Retrofit\n" + "- Room\n" + "- Coroutine\n" + "- Hilt\n" + "- Koin\n" + "- RxJava\n" + "\n" + "\n" + "D'un point de vu personnel et via mes études en bachelor universitaire de technologie j'ai pu également mené à bien quelques petits projets afin de m'ouvrir au dévelopement mobile via par d'autre façon, tel que Flutter et Kotlin KMM.\n" + "\n" + "Mon github est disponible à cette adresse. \n" + "\n" + "Dans le passé, j'ai pu effectué un an en apprentissage pour devenir mécanicien automobile, pour finalement me réorienter.\n" + "\n" + "#Informatique #DevMobile #Programmation #Android #Kotlin #Compose"
                                    )
                                }
                            }
                            items(list) { exp ->
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(exp.name)
                                    Text(exp.age.toString())
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
    @kotlinx.serialization.Serializable
    data object MainPage : Routes

    @kotlinx.serialization.Serializable
    data object AboutPage : Routes

    @Serializable
    data object ContactPage : Routes
}