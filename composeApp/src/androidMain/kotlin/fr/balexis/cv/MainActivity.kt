package fr.balexis.cv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.linkedin
import fr.balexis.cv.component.ProfessionalMediaCap
import org.jetbrains.compose.resources.painterResource

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

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun contactDialog(
    //onEvent: (event: ContactEvent) -> Unit

) {
    Dialog(
        onDismissRequest = { }
    ) {
        Card(
            modifier = Modifier.padding(16.dp),
            elevation = 8.dp,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Me contacter")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    "Pour me contacter rien de plus simple, vous avez l'embarras du choix!"
                )
                InfoRow(
                    imageVector = Icons.Default.Phone,
                    text = "07.81.70.86.41"
                )
                InfoRow(
                    imageVector = Icons.Default.Email,
                    text = "thomas.johnson@example.com"
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(size = 30.dp),
                        tint = Color.Unspecified,
                        painter = painterResource(Res.drawable.linkedin),
                        contentDescription = null

                    )
                    Text(text = "BLANC Alexis")

                }
            }
        }
    }
}

@Composable
fun InfoRow(
    imageVector: ImageVector,
    text: String
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            modifier = Modifier.size(size = 30.dp),
            imageVector = imageVector,
            contentDescription = null

        )
        Text(text = text)

    }
}