@file:OptIn(ExperimentalLayoutApi::class)

package fr.balexis.cv.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Chip
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.cpp_icon
import balexiscv.composeapp.generated.resources.dart_icon
import balexiscv.composeapp.generated.resources.java_icon
import balexiscv.composeapp.generated.resources.javascript_icon
import balexiscv.composeapp.generated.resources.kotlin_icon
import balexiscv.composeapp.generated.resources.php_icon
import balexiscv.composeapp.generated.resources.python_icon
import balexiscv.composeapp.generated.resources.sql_icon
import fr.balexis.cv.theme.LocalAppColors
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

val libraryKnowAndroidNative = listOf(
    "Retrofit", "Room", "Coroutine", "Flow", "Koin", "RXJava", "Hilt", "Coil", "Paging3", "Maps"
)

val libraryKnowFlutter = listOf(
    "Riverpod", "Bloc", "Hive", "Dio", "Injectable + Get It", "Maps"
)

val libraryKnowKMP = listOf(
    "Ktor", "Kotlin Serialization", "Room", "Koin", "Maps"
)


//Faire un genre de carousel horizontalPager
@Composable
fun HorizontalPagerIconButtonControl(
    modifier: Modifier, event: (HorizontalPagerDesktopControl) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = { event(HorizontalPagerDesktopControl.OnLeftButtonClick) },
            modifier = Modifier.clip(
                CircleShape
            ).background(Color.Black.copy(alpha = 0.5f))
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = LocalAppColors.current.onBackground
            )
        }
        IconButton(onClick = { event(HorizontalPagerDesktopControl.OnRightButtonClick) }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = LocalAppColors.current.onBackground
            )
        }

    }
}

sealed class HorizontalPagerDesktopControl() {
    object OnLeftButtonClick : HorizontalPagerDesktopControl()
    object OnRightButtonClick : HorizontalPagerDesktopControl()
}

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
        modifier = modifier
        //Fait crash avec key item100

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Image(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(leadIcon),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(0.2f)
                    .padding(top = 16.dp, start = 16.dp, bottom = 16.dp)
            )
            Column(
                modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(16.dp))
                    .background(LocalAppColors.current.surface).border(1.dp, Color.Black, RoundedCornerShape(16.dp))
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceEvenly,

                ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
                IconTextRow(subtitle, icon = Icons.Default.Build)
                IconTextRow(description, icon = viewIcon)
                CustomDivider(0.8f)
                LibraryKnow(
                    libs = libraries
                )
            }
        }
    }
}

@Composable
private fun IconTextRow(text: String, icon: ImageVector) {
    Row(
        modifier = Modifier.wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon, modifier = Modifier.size(24.dp), contentDescription = null
        )
        Text(
            text = text, modifier = Modifier.padding(start = 8.dp),
        )
    }

}

@Composable
private fun IconTextRow(text: String, icon: DrawableResource) {
    Row(
        modifier = Modifier.wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            tint = Color.Unspecified,
            painter = painterResource(icon),
            modifier = Modifier.size(24.dp),
            contentDescription = null
        )
        Text(
            text = text, modifier = Modifier.padding(start = 8.dp)
        )
    }

}


//Lib que je connais
@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun LibraryKnow(
    libs: List<String>
) {
    var maxLines by remember {
        mutableIntStateOf(2)
    }
    var morePresse by remember { mutableStateOf(false) }
    val overflow = ContextualFlowRowOverflow.expandOrCollapseIndicator(
        expandIndicator = {
            Chip(content = { Text("Plus", fontSize = 14.sp) }, onClick = {
                morePresse = true
            })
        },
        collapseIndicator = {
            Chip(content = { Text("Moins", fontSize = 12.sp) }, onClick = {
                morePresse = false
            })
        },
    )
    ContextualFlowRow(
        modifier = Modifier.fillMaxWidth().animateContentSize(),
        maxLines = 2,
        itemCount = libs.size,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        overflow = overflow
    ) {
        libs.forEach {
            Chip(content = { Text(it, fontSize = 12.sp) }, onClick = {})
        }
    }
}


@Composable
fun archi(
    list: List<String> = listOf("MVVM", "MVC", "MVI", "Clean architecture")
) {
    Row(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp))
            .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
            .background(LocalAppColors.current.surface),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        list.forEach {
            Text(it)
        }
    }
}


sealed class ProgrammingLanguage(
    val name: String,
    val icon: DrawableResource
){
    object Kotlin : ProgrammingLanguage("Kotlin", Res.drawable.kotlin_icon)
    object Java : ProgrammingLanguage("Java", Res.drawable.java_icon)
    object Python : ProgrammingLanguage("Python", Res.drawable.python_icon)
    object PHP : ProgrammingLanguage("PHP", Res.drawable.php_icon)
    object Cpp : ProgrammingLanguage("C++", Res.drawable.cpp_icon)
    object Javascript : ProgrammingLanguage("Javascript", Res.drawable.javascript_icon)
    object SQL : ProgrammingLanguage("SQL", Res.drawable.sql_icon)
    object Dart : ProgrammingLanguage("Dart", Res.drawable.dart_icon)

    companion object {
        val entries: List<ProgrammingLanguage> = listOf(
            Kotlin, Java, Python, PHP, Cpp, Javascript, SQL, Dart
        )
    }
}
