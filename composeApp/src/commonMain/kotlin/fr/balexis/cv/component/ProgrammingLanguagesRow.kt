package fr.balexis.cv.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.compose_multiplatform

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProgrammingLanguageRow(
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
