package fr.balexis.cv.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import fr.balexis.cv.model.BaseItemData
import fr.balexis.cv.theme.columbiaBlue
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

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
            exp.mainIcon?.let {
                Icon(
                    modifier = Modifier.size(40.dp),
                    tint = Color.Unspecified,
                    painter = painterResource(it),
                    contentDescription = null
                )
            }
        }, secondaryText = {
            Text(stringResource(exp.description) , maxLines = 1, overflow = TextOverflow.Ellipsis)
        }, trailing = {
            Text(exp.date)
        })
    }
}
