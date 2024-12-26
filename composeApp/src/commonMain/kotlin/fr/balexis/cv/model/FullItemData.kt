package fr.balexis.cv.model

import org.jetbrains.compose.resources.DrawableResource

data class FullItemData(
    override val title: String,
    override val description: String,
    override val date: String,
    override val mainIcon: DrawableResource? = null,
    val tags: List<String>,
    val companyName: String = "",
) : BaseItemData(title, description, date, mainIcon)