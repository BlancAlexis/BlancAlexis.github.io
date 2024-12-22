package fr.balexis.cv.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
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
import balexiscv.composeapp.generated.resources.istockphoto_1090878494_612x612
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 3.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(Res.drawable.istockphoto_1090878494_612x612),
            modifier = Modifier.widthIn(max = 150.dp),
            contentDescription = null,
        )
        Text(
            maxLines = 1,
            text = "BLANC Alexis",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.weight(1F).padding(start = 16.dp).offset(x = -(8).dp)
                .align(Alignment.Bottom)
        )
    }
}