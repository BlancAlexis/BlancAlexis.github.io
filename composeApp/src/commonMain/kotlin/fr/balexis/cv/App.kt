package fr.balexis.cv

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.balexis.cv.component.contactDialog
import fr.balexis.cv.theme.DarkAppColors
import fr.balexis.cv.theme.LightAppColors
import fr.balexis.cv.theme.LocalAppColors
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    var dialogContact = remember { mutableStateOf(false) }
    CompositionLocalProvider(
        LocalAppColors provides if (isSystemInDarkTheme()) {
            DarkAppColors
        } else {
            LightAppColors
        }
    )
    {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Routes.MainPage,
        ) {
            composable<Routes.MainPage> {
                MainPage(
                    onEvent = {
                        dialogContact.value = true
                    }
                )
                if (dialogContact.value) {
                    contactDialog(
                        onEvent = {
                            dialogContact.value = false
                        }
                    )
                }
            }

        }
    }
}

sealed interface Routes {
    @Serializable
    data object MainPage : Routes

}


