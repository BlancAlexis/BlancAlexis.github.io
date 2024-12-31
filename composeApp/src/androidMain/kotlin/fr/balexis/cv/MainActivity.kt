package fr.balexis.cv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.balexis.cv.component.ProfessionalMediaCap

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun professionalCapPreview() {
    ProfessionalMediaCap(
        onEvent = {}
    )
}




