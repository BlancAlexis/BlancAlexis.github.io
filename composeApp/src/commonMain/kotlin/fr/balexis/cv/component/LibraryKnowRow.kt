package fr.balexis.cv.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.balexis.cv.theme.vistaBlue

@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun LibraryKnow(
    libs: List<String>
) {
    var maxLines by remember {
        mutableIntStateOf(1)
    }
    var remainingItems = 0
    ContextualFlowRow(
        modifier = Modifier.fillMaxWidth().wrapContentHeight().animateContentSize(),
        maxLines = maxLines,
        itemCount = libs.size,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        overflow = ContextualFlowRowOverflow.expandOrCollapseIndicator(
            minRowsToShowCollapse = 2,
            expandIndicator = {
                Chip(
                    content = { Text("+$remainingItems") },
                    onClick = { maxLines = 4 },
                    modifier = Modifier.wrapContentSize(),
                    colors = ChipDefaults.chipColors(backgroundColor = vistaBlue)
                )
            },
            collapseIndicator = {
                Chip(
                    content = { Text("Restreindre") },
                    onClick = { maxLines = 1 },
                    modifier = Modifier.wrapContentSize(),
                    colors = ChipDefaults.chipColors(backgroundColor = vistaBlue)
                )
            }
        ),
    ) { index ->
        remainingItems = libs.size - index
        Chip(content = { Text(libs[index], fontSize = 12.sp) }, onClick = {})
    }
}