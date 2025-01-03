package fr.balexis.cv.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.balexis.cv.theme.LocalAppColors
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun FrameworkCard(
    title: String,
    subtitle: String,
    description: String,
    leadIcon: DrawableResource,
    viewIcon: DrawableResource,
    libraries: List<String>,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.border(1.dp, Color.Black, RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier.wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                contentScale = ContentScale.FillWidth,
                painter = painterResource(leadIcon),
                contentDescription = null,
                modifier = Modifier.size(80.dp).fillMaxWidth(0.2f).padding(horizontal = 8.dp)
            )
            Column(
                modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(16.dp))
                    .background(LocalAppColors.current.secondary)
                    .border(1.dp, Color.Black, RoundedCornerShape(16.dp)).padding(8.dp),

                ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
                IconTextRow(subtitle, icon = Icons.Default.CheckCircle)
                IconTextRow(description, icon = viewIcon)
                CustomDivider(0.8f)
                LibraryKnow(
                    libs = libraries
                )
            }
        }
    }
}