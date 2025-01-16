package fr.balexis.cv.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.b_alexis
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 25.dp, top = 16.dp)
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(Res.drawable.b_alexis),
            modifier = Modifier.widthIn(max = 150.dp),
            contentDescription = null,
        )

        Column(
            modifier = Modifier.weight(1F).align(Alignment.Bottom),
        ) {
            AutoResizedText(
                text = "BLANC Alexis",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    letterSpacing = 0.1.sp,
                    lineHeight = 2.sp,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif
                ),
            )
            AutoResizedText(
                text = "Recherche poste développeur mobile",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    letterSpacing = 0.1.sp,
                    lineHeight = 2.sp,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif
                ),
                modifier = Modifier.padding(start = 8.dp)
            )

        }

    }
}


