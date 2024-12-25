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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Chip
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.balexis.cv.theme.LocalAppColors
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

val libraryKnowAndroidNative = listOf(
    "Retrofit",
    "Room",
    "Coroutine",
    "Flow",
    "Koin",
    "RXJava",
    "Hilt",
    "Coil",
    "Paging3",
    "Maps"
)

val libraryKnowFlutter = listOf(
    "Riverpod",
    "Bloc",
    "Hive",
    "Dio",
    "Injectable + Get It",
    "Maps"
)

val libraryKnowKMP = listOf(
    "Ktor",
    "Kotlin Serialization",
    "Room",
    "Koin",
    "Maps"
)


//Faire un genre de carousel horizontalPager

@Composable
fun FrameworkCard(
    title: String,
    subtitle: String,
    description: String,
    icon: DrawableResource,
    libraries: List<String>,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier =
            Modifier.fillMaxWidth().fillMaxHeight(0.4f) //Fait crash avec key item100

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Image(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.fillMaxHeight().fillMaxWidth(0.3f)
                    .padding(top = 16.dp, start = 16.dp, bottom = 16.dp)
            )
            Column(
                modifier = Modifier.fillMaxHeight()
                    .clip(RoundedCornerShape(4.dp)).background(LocalAppColors.current.surface)
                    .border(1.dp, Color.Black, RoundedCornerShape(4.dp)).padding(8.dp),
                verticalArrangement = Arrangement.SpaceEvenly,

                ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
                IconTextRow(subtitle, icon = Icons.Default.Build)
                IconTextRow(description, icon = Icons.Default.Build)
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
            imageVector = icon,
            modifier = Modifier.size(24.dp),
            contentDescription = null
        )
        Text(
            text = text,
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

@Composable
fun SkillsCard() {
    val skills = listOf("Android", "Kotlin", "Java", "Python", "PHP", "C++", "SQL", "Javascript")
    Card {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Skills")
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(skills) {
                    Text("$it")
                }
            }
        }
    }
}


@Composable
fun AbilitySkillsRow(
) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SkillsCard()
        SkillsCard()
    }
}


@Composable
fun controlOverPager() {

}

fun Modifier.cardControlOverPager(position: Int, lastIndex: Int, event: () -> Unit): Modifier =
    graphicsLayer {

    }

fun Modifier.circle(color: Color) = this then CircleElement(color)

private data class CircleElement(val color: Color) : ModifierNodeElement<ControlNode>() {
    override fun create() = ControlNode(color)

    override fun update(node: ControlNode) {
        node.color = color
    }
}

private class ControlNode(var color: Color = Color.Red) : DrawModifierNode, Modifier.Node() {
    override fun ContentDrawScope.draw() {
        drawCircle(Color.Red, radius = 10f)
    }

}