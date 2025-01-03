package fr.balexis.cv.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun IconTextRow(text: String, icon: ImageVector) {
    Row(
        modifier = Modifier.wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon, modifier = Modifier.size(24.dp), contentDescription = null
        )
        Text(
            text = text, modifier = Modifier.padding(start = 8.dp),
        )
    }

}

@Composable
fun IconTextRow(text: String, icon: DrawableResource) {
    Row(
        modifier = Modifier.wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            tint = Color.Unspecified,
            painter = painterResource(icon),
            modifier = Modifier.size(24.dp),
            contentDescription = null
        )
        Text(
            text = text, modifier = Modifier.padding(start = 8.dp)
        )
    }

}