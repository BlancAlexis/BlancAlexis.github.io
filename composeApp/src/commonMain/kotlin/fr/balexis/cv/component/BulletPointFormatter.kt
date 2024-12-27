package fr.balexis.cv.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BulletPointFormatter(
    modifier: Modifier = Modifier,
    text: String,
    bulletColor: Color = Color.Black,
    bulletSize: Float = 5f,
    textColor: Color = Color.Black,
    textSize: Int = 14,
    boldSection: List<String> = emptyList()
) {
    var textFormatted = text
    val cautionText = if (text.contains("*")) { text.split("*").last() } else { null }
    if (!cautionText.isNullOrEmpty()) {
        textFormatted = text.removeRange(text.indexOf("*"), text.length)
    }
    val bulletPoints = textFormatted.split("-").filter { it.isNotBlank() }

    Column(modifier = modifier) {
        bulletPoints.forEachIndexed { index, point ->
            Row(verticalAlignment = Alignment.Top) {
                if (index != 0) {
                    Canvas(modifier = Modifier.padding(top = 8.dp).size(10.dp)) {
                        drawCircle(
                            color = bulletColor,
                            radius = bulletSize,
                            center = Offset(x = size.width / 2, y = size.height / 2),
                            style = Fill
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))
                }

                Text(
                    text = buildAnnotatedString {
                        val words = point.trim().split(" ")
                        words.forEach { word ->
                            val isBold = boldSection.any { word.contains(it, ignoreCase = true) }
                            if (isBold) {
                                withStyle(
                                    style = SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = textColor,
                                        fontSize = textSize.sp
                                    )
                                ) {
                                    append("$word ")
                                }
                            } else {
                                withStyle(
                                    style = SpanStyle(
                                        color = textColor, fontSize = textSize.sp
                                    )
                                ) {
                                    append("$word ")
                                }
                            }
                        }
                    }, modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
        if (!cautionText.isNullOrEmpty()) {
            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold, color = Color.Red, fontSize = textSize.sp
                    )
                ) {
                    append(cautionText)
                }
            })
        }
    }
}