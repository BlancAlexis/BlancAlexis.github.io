package fr.balexis.cv

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.compose_multiplatform
import kotlinx.serialization.Serializable

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
      NavHost(
          navController = navController,
          startDestination = Routes.MainPage,
      ){
          composable<Routes.MainPage>{
              Column {
                  Button(
                      onClick = { navController.navigate(Routes.AboutPage) },
                      modifier = Modifier.align(Alignment.CenterHorizontally)
                  ){
                      Text("About")
                  }
                  Button(
                      onClick = { navController.navigate(Routes.ContactPage) },
                      modifier = Modifier.align(Alignment.CenterHorizontally)){
                          Text("Contact")
                  }
              }
          }
          composable<Routes.AboutPage>{

          }
          composable<Routes.ContactPage>{

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