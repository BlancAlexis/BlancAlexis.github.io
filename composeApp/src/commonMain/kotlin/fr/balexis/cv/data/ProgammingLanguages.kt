package fr.balexis.cv.data

import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.cpp_icon
import balexiscv.composeapp.generated.resources.dart_icon
import balexiscv.composeapp.generated.resources.java_icon
import balexiscv.composeapp.generated.resources.javascript_icon
import balexiscv.composeapp.generated.resources.kotlin_icon
import balexiscv.composeapp.generated.resources.php_icon
import balexiscv.composeapp.generated.resources.python_icon
import balexiscv.composeapp.generated.resources.sql_icon
import org.jetbrains.compose.resources.DrawableResource

sealed class ProgrammingLanguage(
    val name: String,
    val icon: DrawableResource
) {
    data object Kotlin : ProgrammingLanguage("Kotlin", Res.drawable.kotlin_icon)
    data object Java : ProgrammingLanguage("Java", Res.drawable.java_icon)
    data object Python : ProgrammingLanguage("Python", Res.drawable.python_icon)
    data object PHP : ProgrammingLanguage("PHP", Res.drawable.php_icon)
    data object Cpp : ProgrammingLanguage("C++", Res.drawable.cpp_icon)
    data object Javascript : ProgrammingLanguage("Javascript", Res.drawable.javascript_icon)
    data object SQL : ProgrammingLanguage("SQL", Res.drawable.sql_icon)
    data object Dart : ProgrammingLanguage("Dart", Res.drawable.dart_icon)

    companion object {
        val entries: List<ProgrammingLanguage> = listOf(
            Kotlin, Java, Python, PHP, Cpp, Javascript, SQL, Dart
        )
    }
}