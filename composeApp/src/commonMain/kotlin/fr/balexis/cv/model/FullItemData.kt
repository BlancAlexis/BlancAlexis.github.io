package fr.balexis.cv.model

data class FullItemData(
    override val title: String,
    override val description: String,
    override val date: String,
    val tags: List<String>,
    val companyName: String = ""
) : BaseItemData(title, description, date)