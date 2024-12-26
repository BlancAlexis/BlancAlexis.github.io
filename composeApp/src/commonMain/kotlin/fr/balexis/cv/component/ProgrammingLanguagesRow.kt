package fr.balexis.cv.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.balexis.cv.data.ProgrammingLanguage

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProgrammingLanguageRow(
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp), horizontalArrangement = Arrangement.Center
    ) {
        for (language in ProgrammingLanguage.entries) {
            LanguageRowItem(language.name, language.icon)
        }
    }
}
