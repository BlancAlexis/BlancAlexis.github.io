package fr.balexis.cv.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.compose_multiplatform

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProgrammingLanguageRow(
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp), horizontalArrangement = Arrangement.Center
    ) {
        for (ProgrammingLanguage in ProgrammingLanguage.entries) {
            LanguageRowItem(ProgrammingLanguage.name, ProgrammingLanguage.icon)
        }
    }
}
