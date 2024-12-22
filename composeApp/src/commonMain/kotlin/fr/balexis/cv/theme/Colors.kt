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
    primary = paynesGray,
    secondary = vistaBlue,
    background = pearl,
    surface = sage, 
    onPrimary = pearl,
    onBackground = paynesGray
)


val DarkAppColors = AppColors(
    primary = paynesGray,
    secondary = columbiaBlue,
    background = pearl,
    surface = sage,
    onPrimary = pearl,
    onBackground = paynesGray
)

val LocalAppColors = staticCompositionLocalOf {
    DarkAppColors
}

