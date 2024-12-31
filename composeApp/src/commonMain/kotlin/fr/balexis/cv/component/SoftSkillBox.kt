package fr.balexis.cv.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.compose_multiplatform
import fr.balexis.cv.theme.vistaBlue
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun SoftSkillBox(
    text: String, icon: DrawableResource
) {
    Box(
        modifier = Modifier.clip(RoundedCornerShape(16.dp))
            .border(1.dp, Color.Black, RoundedCornerShape(16.dp)).size(80.dp).background(vistaBlue)
    ) {
        Icon(
            imageVector = Icons.Default.Build,
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 8.dp),
            // painter = painterResource(icon),
            contentDescription = null
        )
        Text(
            text, modifier = Modifier.align(Alignment.Center).matchParentSize()
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SoftSkillRow(
    softSkills: List<String>
) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        softSkills.forEach {
            SoftSkillBox(it, Res.drawable.compose_multiplatform)
        }
    }
}
