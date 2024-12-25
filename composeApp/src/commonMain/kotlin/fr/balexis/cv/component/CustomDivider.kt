package fr.balexis.cv.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomDivider( width : Float) {
    Divider(
        color = Color.Black,
        thickness = 1.dp,
        modifier = Modifier.widthIn(100.dp, 300.dp).fillMaxWidth(width).padding(vertical = 8.dp)
    )
}