package fr.balexis.cv.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.linkedin_icon
import fr.balexis.cv.theme.LocalAppColors
import org.jetbrains.compose.resources.painterResource

@Composable
fun ContactDialog(
    onEvent: (event: ContactEvent) -> Unit,
    backgroundColor: Color = LocalAppColors.current.secondary

) {
    val uriHandler = LocalUriHandler.current
    Dialog(onDismissRequest = {
        onEvent(ContactEvent.closeDialog)
    }) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp),
            backgroundColor = backgroundColor,
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Me contacter",
                        style = MaterialTheme.typography.h3,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    "Voici les canaux sur lesquels vous pouvez me contacter"
                )
                InfoRow(
                    imageVector = Icons.Default.Phone,
                    text = "07.81.70.86.41",
                    onClick = {
                    }
                )
                InfoRow(
                    imageVector = Icons.Default.Email,
                    text = "blanc.alexispro@gmail.com",
                    onClick = {
                        uriHandler.openUri("mailto:blanc.alexispro@gmail.com")
                    }
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.clickable {
                        uriHandler.openUri("https://www.linkedin.com/in/alexis--blanc/")
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(size = 30.dp),
                        tint = Color.Unspecified,
                        painter = painterResource(Res.drawable.linkedin_icon),
                        contentDescription = null

                    )
                    Text(text = "BLANC Alexis")

                }
            }
        }
    }
}

sealed interface ContactEvent {
    object closeDialog : ContactEvent

}

@Composable
fun InfoRow(
    imageVector: ImageVector, text: String, onClick: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(
            modifier = Modifier.size(size = 30.dp),
            imageVector = imageVector,
            contentDescription = null

        )
        Text(text = text, maxLines = 1, overflow = TextOverflow.Ellipsis)

    }
}