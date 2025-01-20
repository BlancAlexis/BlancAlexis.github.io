package fr.balexis.cv.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

val topShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
val bottomShape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)

@Composable
fun LazyColumnCategory(
    itemCount: Int,
    idx: Int,
    content: @Composable (Shape) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        content(
            when {
                itemCount == 1 -> RoundedCornerShape(4.dp)
                idx == 0 -> topShape
                idx == itemCount - 1 -> bottomShape
                else -> RectangleShape
            }
        )
    }
}

