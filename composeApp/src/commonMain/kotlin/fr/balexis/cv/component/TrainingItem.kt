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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import fr.balexis.cv.data.BaseItemData

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TrainingItem(exp: BaseItemData, shape: Shape) {
    Card(
        shape = shape,
        backgroundColor = Color(0xFF3C91E6),
    ) {

        Card(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            elevation = 2.dp,
        ) {
            ListItem(text = {
                Text(exp.title)
            }, icon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.List, contentDescription = null
                )
            }, secondaryText = {
                Text(exp.description)
            }, trailing = {
                Text(exp.date)
            })
        }
    }
}