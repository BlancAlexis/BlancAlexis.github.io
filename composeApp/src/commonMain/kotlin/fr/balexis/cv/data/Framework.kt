package fr.balexis.cv.data

import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.android_icon
import balexiscv.composeapp.generated.resources.compose_icon
import balexiscv.composeapp.generated.resources.compose_multiplatform
import balexiscv.composeapp.generated.resources.flutter_icon
import balexiscv.composeapp.generated.resources.kotlin_icon
import org.jetbrains.compose.resources.DrawableResource

enum class Framework(
    val title: String,
    val languages: String,
    val view: String,
    val icon: DrawableResource,
    val libraries: List<String>,
    val viewIcon: DrawableResource

) {

    AndroidNative(
        title = "Android Native",
        languages = "Kotlin & Java",
        view = "Compose & XML",
        icon = Res.drawable.android_icon,
        libraries = libraryKnowAndroidNative,
        viewIcon = Res.drawable.compose_icon
    ),
    Flutter(
        title = "Flutter",
        languages = "Dart",
        view = "Flutter",
        icon = Res.drawable.flutter_icon,
        libraries = libraryKnowFlutter,
        viewIcon = Res.drawable.flutter_icon
    ),
    KMP(
        title = "KMP",
        languages = "Kotlin",
        view = "Compose mutliplateform",
        icon = Res.drawable.kotlin_icon,
        libraries = libraryKnowKMP,
        viewIcon = Res.drawable.compose_multiplatform
    );
}