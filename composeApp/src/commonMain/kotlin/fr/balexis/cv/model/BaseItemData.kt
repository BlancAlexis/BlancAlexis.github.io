package fr.balexis.cv.model

import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.mortarboard_icon
import org.jetbrains.compose.resources.DrawableResource

open class BaseItemData(
    open val title: String,
    open val description: String,
    open val date: String,
    open val mainIcon: DrawableResource ?= Res.drawable.mortarboard_icon
)