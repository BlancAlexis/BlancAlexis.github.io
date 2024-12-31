package fr.balexis.cv.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
data class AppColors(
    val primary: Color,
    val secondary: Color,
    val background: Color,
    val surface: Color,
    val onPrimary: Color,
    val onBackground: Color
)


val vistaBlue = Color(0xFF80A4ED)
val pearl = Color(0xFFE6E1C5)
val sage = Color(0xFFD4CB92)
val paynesGray = Color(0xFF395C6B)
val columbiaBlue = Color(0xFFBCD3F2)

val LightAppColors = AppColors(
    primary = sage,
    secondary = columbiaBlue,
    background = paynesGray,
    surface = pearl,
    onPrimary = Color.Black,
    onBackground = Color.Black
)


val DarkAppColors = AppColors(
    primary = sage,
    secondary = columbiaBlue,
    background = paynesGray,
    surface = pearl,
    onPrimary = Color.Black,
    onBackground = Color.Black
) //TODO dark theme

val LocalAppColors = staticCompositionLocalOf {
    DarkAppColors
}

