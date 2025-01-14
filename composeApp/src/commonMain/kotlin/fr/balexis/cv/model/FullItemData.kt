package fr.balexis.cv.model

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class FullItemData(
    override val title: String,
    override val date: String,
    override val description: StringResource,
    override val mainIcon: DrawableResource? = null,
    val tags: List<String>,
    val secondaryText: String = "",
) : BaseItemData(title, description, date, mainIcon)