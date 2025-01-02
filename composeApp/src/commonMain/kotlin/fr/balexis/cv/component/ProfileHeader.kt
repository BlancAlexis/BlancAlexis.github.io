package fr.balexis.cv.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.b_alexis
import fr.balexis.cv.getPlatform
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 30.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(Res.drawable.b_alexis),
            modifier = Modifier.platformImageSize().align(Alignment.CenterVertically),
            contentDescription = null,
        )
        Text(
            maxLines = 1,
            text = "BLANC Alexis",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.weight(1F).padding(start = 8.dp)
                .align(Alignment.Bottom)
        )
    }
}

@Composable
fun Modifier.platformImageSize(): Modifier {
    return when (getPlatform()) {
        "JS" -> this then Modifier.widthIn(max = 300.dp)
        "Android" -> this then Modifier.widthIn(max = 150.dp)
        else -> {
            Modifier
        }
    }
}