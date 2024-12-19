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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

sealed interface SocialNav {
    data object Linkedin : SocialNav
    data object Github : SocialNav
    data object Mail : SocialNav

}

@Composable
@Preview
fun ProfessionalMediaCap(
    modifier: Modifier = Modifier, onEvent: (event: SocialNav) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center, modifier = modifier.then(
            Modifier
                .fillMaxWidth(0.7f)
                .wrapContentWidth(Alignment.End)
                .heightIn(50.dp, 100.dp)
                .clip(
                    shape = RoundedCornerShape(
                        bottomStart = 32.dp, bottomEnd = 32.dp
                    )
                )
                .background(Color(0xFF902923))
        ),
        verticalAlignment = Alignment.CenterVertically

    ) {
        IconButton(onClick = {
            onEvent(SocialNav.Linkedin)
        }

        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null

            )
        }
        IconButton(onClick = {
            onEvent(SocialNav.Github)
        }

        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null

            )
        }
        IconButton(onClick = {
            onEvent(SocialNav.Mail)
        }

        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null

            )
        }
    }
}

sealed class MySocial(
    val name: String, open val url: String
) {
    data class LKDN(override val url: String) : MySocial("linkedin", url)
}