package fr.balexis.cv.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.compose_multiplatform
import balexiscv.composeapp.generated.resources.english_flag
import balexiscv.composeapp.generated.resources.french_flag
import fr.balexis.cv.theme.LocalAppColors
import fr.balexis.cv.theme.vistaBlue
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun LanguageRowItem(
    text: String, icon: DrawableResource
) {
    Row(
        Modifier.wrapContentSize().clip(RoundedCornerShape(8.dp)).background(LocalAppColors.current.secondary)
            .border(1.dp, Color.Black, RoundedCornerShape(8.dp)).padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            tint = Color.Unspecified,
            modifier = Modifier.size(24.dp),
            painter = painterResource(icon),
            contentDescription = null
        )
        Text(
            text, fontSize = 14.sp, modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun LanguageRow(
) {
    Row(
        modifier = Modifier.clip(RoundedCornerShape(16.dp)).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Language.entries.forEach {
            LanguageRowItem(it.text, it.icon)
        }
    }

}

enum class Language(
    val text: String, val icon: DrawableResource
){
    FRENCH("Français : Langue natale", Res.drawable.french_flag),
    ENGLISH("Anglais : Niveau B1", Res.drawable.english_flag)

}