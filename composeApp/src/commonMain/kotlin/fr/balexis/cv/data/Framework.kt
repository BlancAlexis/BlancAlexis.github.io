package fr.balexis.cv.data

import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.compose_icon
import balexiscv.composeapp.generated.resources.compose_multiplatform
import balexiscv.composeapp.generated.resources.flutter_icon
import balexiscv.composeapp.generated.resources.kotlin_icon
import fr.balexis.cv.component.libraryKnowAndroidNative
import fr.balexis.cv.component.libraryKnowFlutter
import fr.balexis.cv.component.libraryKnowKMP
import org.jetbrains.compose.resources.DrawableResource

enum class Framework(
    val title: String,
    val langages: String,
    val view: String,
    val icon: DrawableResource,
    val libraries: List<String>,
    val viewIcon: DrawableResource

) {

    AndroidNative(
        title = "Android Native",
        langages = "Kotlin & Java",
        view = "Compose & XML",
        icon = Res.drawable.compose_multiplatform,
        libraries = libraryKnowAndroidNative,
        viewIcon = Res.drawable.compose_icon
    ),
    Flutter(
        title = "Flutter",
        langages = "Dart",
        view = "Flutter",
        icon = Res.drawable.flutter_icon,
        libraries = libraryKnowFlutter,
        viewIcon = Res.drawable.flutter_icon
    ),
    KMP(
        title = "KMP",
        langages = "Kotlin",
        view = "Compose mutliplateform",
        icon = Res.drawable.kotlin_icon,
        libraries = libraryKnowKMP,
        viewIcon = Res.drawable.compose_multiplatform
    );
}