package fr.balexis.cv.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun stickyHeaderContent(
    text: String
) {
    Row(
        modifier = Modifier.drawBehind {
            drawRect(Color(0xFF00888F), size = size.copy(height = size.height / 2))
        }.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(Color(0xFF2F5475))
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text)
    }
    Spacer(modifier = Modifier.height(8.dp))
}