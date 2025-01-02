package fr.balexis.cv.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.battery_icon
import balexiscv.composeapp.generated.resources.build_icon
import balexiscv.composeapp.generated.resources.perfect_icon
import fr.balexis.cv.theme.vistaBlue
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun SoftSkillBox(
    text: String, icon: DrawableResource
) {
    Box(
        modifier = Modifier.clip(RoundedCornerShape(16.dp))
            .border(1.dp, Color.Black, RoundedCornerShape(16.dp)).size(80.dp).background(vistaBlue)
    ) {
        Icon(
            modifier = Modifier.align(Alignment.TopCenter).size(24.dp).offset(y = 4.dp),
            painter = painterResource(icon),
            contentDescription = null
        )
        Text(
            text, modifier = Modifier.align(Alignment.Center).matchParentSize()
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SoftSkillRow() {
    FlowRow(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SoftSkill.entries.forEach {
            SoftSkillBox(it.title, it.icon)
        }
    }
}

enum class SoftSkill(val title: String, val icon: DrawableResource) {
    Adaptability("Adaptabilité", Res.drawable.build_icon),
    Autonomy("Autonomie", Res.drawable.battery_icon),
    Rigor("Rigeur", Res.drawable.perfect_icon),

}