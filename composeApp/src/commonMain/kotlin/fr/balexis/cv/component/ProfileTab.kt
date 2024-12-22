@file:OptIn(ExperimentalLayoutApi::class)

package fr.balexis.cv.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun LanguageRowItem(
    text: String, icon: DrawableResource
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(icon),
            contentDescription = null
        )
        Text(
            text, fontSize = 14.sp,
        )
    }
}

@Composable
fun LanguageRow(
    language: List<String>
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        language.forEach {
            LanguageRowItem(it, Res.drawable.compose_multiplatform)
        }
    }

}

@Composable
fun SoftSkillBox(
    text: String, icon: DrawableResource
) {
    Box(
        modifier = Modifier.clip(RoundedCornerShape(16.dp))
            .border(1.dp, Color.Black, RoundedCornerShape(16.dp)).size(100.dp)
            .background(Color.Yellow)
    ) {
        Icon(
            imageVector = Icons.Default.Build,
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 16.dp),
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

//Faire un genre de carousel horizontalPager

@Composable
fun FrameworkCard(
    text: String, icon: DrawableResource
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(0.2f)
            ) {
                Image(
                    painter = painterResource(icon), contentDescription = null
                )
            }
            Column(
                modifier = Modifier.weight(1f).clip(RoundedCornerShape(4.dp)).background(Color.Red)
                    .border(1.dp, Color.Black, RoundedCornerShape(4.dp)).padding(start = 8.dp),

                ) {
                Text("Android", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                Text("Kotlin & Java")
                Text("Compose & XML")
                LibraryKnow(
                    listOf("Kotlin", "Java", "Android Studio")
                )
            }

        }

    }
}


@Composable
fun controlOverPager() {

}


//Lib que je connais
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LibraryKnow(
    libs: List<String>
) {
    Row {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            items(items = libs) {
                Chip(content = { Text(it, fontSize = 12.sp) }, onClick = {})
            }
        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CountryRow(
) {
    FlowRow(
        verticalArrangement = Arrangement.spacedBy(8.dp), horizontalArrangement = Arrangement.Center
    ) {
        LanguageRowItem("Kotlin", Res.drawable.compose_multiplatform)
        LanguageRowItem("Java", Res.drawable.compose_multiplatform)
        LanguageRowItem("Python", Res.drawable.compose_multiplatform)
        LanguageRowItem("PHP", Res.drawable.compose_multiplatform)
        LanguageRowItem("C++", Res.drawable.compose_multiplatform)
        LanguageRowItem("SQL", Res.drawable.compose_multiplatform)
        LanguageRowItem("Javascript", Res.drawable.compose_multiplatform)
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

fun Modifier.controlOverPager(): Modifier =
    clip(RoundedCornerShape(16.dp)).border(1.dp, Color.Black, RoundedCornerShape(16.dp))

