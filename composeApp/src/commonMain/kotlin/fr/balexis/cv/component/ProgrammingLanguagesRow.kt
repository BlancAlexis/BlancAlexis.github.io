package fr.balexis.cv.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.balexis.cv.data.ProgrammingLanguage
import fr.balexis.cv.data.listArchi
import fr.balexis.cv.theme.LocalAppColors

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProgrammingLanguageRow(
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally)
    ) {
        for (language in ProgrammingLanguage.entries) {
            LanguageRowItem(language.name, language.icon)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterialApi::class)
@Composable
fun ArchiRow(
    modifier: Modifier = Modifier,
    list: List<String> = listArchi,
    color: Color = LocalAppColors.current.secondary
) {
    FlowRow(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally)
    ) {
        list.forEach {
            Chip(content = { Text(it, fontSize = 12.sp) },
                colors = ChipDefaults.chipColors(backgroundColor = color),
                onClick = {})
        }
    }
}
