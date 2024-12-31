package fr.balexis.cv.data

import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.compose_multiplatform
import balexiscv.composeapp.generated.resources.contact_icon
import balexiscv.composeapp.generated.resources.github_icon
import balexiscv.composeapp.generated.resources.linkedin_icon
import org.jetbrains.compose.resources.DrawableResource

sealed class ProfessionalNetwork(
    val name: String, val action: String, val icon: DrawableResource
) {
    data object Linkedin : ProfessionalNetwork(
        name = "linkedin",
        action = "Action.onLinkedinClick",
        icon = Res.drawable.linkedin_icon
    )

    data object Github : ProfessionalNetwork("github", " url", Res.drawable.github_icon)
    data object Mail : ProfessionalNetwork("mail", "url", Res.drawable.compose_multiplatform)
    data object Contact : ProfessionalNetwork("contact", "url", Res.drawable.contact_icon)

    companion object {
        val entries: List<ProfessionalNetwork> = listOf(
            Mail,
            Github,
            Linkedin,
            Contact
        )
    }
}

sealed interface Action {
    fun onGithubClick(): Action
    fun onLinkedinClick(): Action
    fun onMailClick(): Action
    fun onContactClick(): Action

}
