package fr.balexis.cv

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.balexis.cv.component.contactDialog
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    var dialogContact = remember { mutableStateOf(false) }
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Routes.MainPage,
        ) {
            composable<Routes.MainPage> {
                MainPage(
                    navigation = {
                        navController.navigate(it)
                    }
                )
                if (dialogContact.value){
                    contactDialog()
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