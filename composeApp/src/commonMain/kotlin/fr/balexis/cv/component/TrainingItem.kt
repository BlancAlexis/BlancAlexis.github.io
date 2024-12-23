package fr.balexis.cv.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import fr.balexis.cv.model.BaseItemData
import fr.balexis.cv.theme.LocalAppColors
import fr.balexis.cv.theme.columbiaBlue

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TrainingItem(exp: BaseItemData) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        backgroundColor = columbiaBlue,
        elevation = 4.dp,
    ) {
        ListItem(text = {
            Text(exp.title)
        }, icon = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.List, contentDescription = null
            )
        }, secondaryText = {
            Text(exp.description, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }, trailing = {
            Text(exp.date)
        })
    }
}
