package fr.balexis.cv.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isUnspecified
import androidx.compose.ui.unit.sp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.b_alexis
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
            modifier = Modifier.widthIn(max = 200.dp).align(Alignment.CenterVertically),
            contentDescription = null,
        )
        AutoResizedText(
            text = "BLANC Alexis",
            style = MaterialTheme.typography.h1.copy(
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier.weight(1F).padding(end = 8.dp)
                .align(Alignment.Bottom)
        )
    }
}


