package fr.balexis.cv

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R

sealed class icon(
    val color: Color?,
    val icon: Int,
    val name: Int
) {
    class LINKEDIN : icon(Color.Blue, R.drawable.linkedin, R.string.linkedin)
    class GITHUB : icon(Color.Black, R.drawable.github, R.string.github)
    class MAIL : icon(Color.Black, R.drawable.mail, R.string.mail)

}