package fr.balexis.cv.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toIntSize
import androidx.compose.ui.unit.toSize
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.android_icon
import balexiscv.composeapp.generated.resources.compose_multiplatform
import balexiscv.composeapp.generated.resources.contact_icon
import balexiscv.composeapp.generated.resources.flutter_icon
import balexiscv.composeapp.generated.resources.github_icon
import balexiscv.composeapp.generated.resources.linkedin_icon
import balexiscv.composeapp.generated.resources.mail_icon
import fr.balexis.cv.theme.LocalAppColors
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

sealed interface SocialNav {
    data object Linkedin : SocialNav
    data object Github : SocialNav
    data object Mail : SocialNav
    data object Contact : SocialNav

}

sealed interface MainScreenEvent {
    data object OpenContactDialog : MainScreenEvent
}

sealed class ProfessionalMedia(
    val name: String, val action: SocialNav, val icon: DrawableResource
){
    data object Linkedin : ProfessionalMedia("linkedin", SocialNav.Linkedin, Res.drawable.linkedin_icon)
    data object Github : ProfessionalMedia("github", SocialNav.Github, Res.drawable.github_icon)
    data object Mail : ProfessionalMedia("mail", SocialNav.Mail, Res.drawable.mail_icon)
    data object Contact : ProfessionalMedia("contact", SocialNav.Contact, Res.drawable.contact_icon)

    companion object{
        val entries: List<ProfessionalMedia> = listOf(
          Mail,Github,Linkedin,Contact
        )
    }
}


@Composable
@Preview
fun ProfessionalMediaCap(
    modifier: Modifier = Modifier, onEvent: (event: SocialNav) -> Unit
) {
    val circleColor = LocalAppColors.current.primary
    Row(
        horizontalArrangement = Arrangement.Center, modifier = modifier.then(
            Modifier.fillMaxWidth(0.7f).wrapContentWidth(Alignment.End).heightIn(50.dp, 100.dp)
                .clip(
                    shape = RoundedCornerShape(
                        bottomStart = 32.dp, bottomEnd = 32.dp
                    )
                ).background(LocalAppColors.current.background)
        ), verticalAlignment = Alignment.CenterVertically

    ) {
        ProfessionalMedia.entries.forEach {
            IconButton(
                modifier = Modifier.circleBackground(circleColor, 20f),
                onClick = {
                    onEvent(it.action)
                }) {
                Icon(
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(it.icon),
                    contentDescription = it.name
                )
            }
        }
    }
}



fun Modifier.circleBackground(color: Color, radius: Float) : Modifier =
    drawBehind {
           drawCircle(
                color = color, radius = radius
           )
    }
