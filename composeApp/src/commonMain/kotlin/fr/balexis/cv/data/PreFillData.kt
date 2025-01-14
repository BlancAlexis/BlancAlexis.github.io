package fr.balexis.cv.data


import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.address_iut
import balexiscv.composeapp.generated.resources.address_lycee
import balexiscv.composeapp.generated.resources.android_icon
import balexiscv.composeapp.generated.resources.description_internship_wimova
import balexiscv.composeapp.generated.resources.description_internship_wimova_year
import balexiscv.composeapp.generated.resources.description_mechanic_internship
import balexiscv.composeapp.generated.resources.description_monuments_of_roubaix
import balexiscv.composeapp.generated.resources.description_nexans
import balexiscv.composeapp.generated.resources.description_project_cv
import balexiscv.composeapp.generated.resources.description_project_no_name
import balexiscv.composeapp.generated.resources.description_project_pokedex
import balexiscv.composeapp.generated.resources.description_sae_android
import balexiscv.composeapp.generated.resources.description_sae_flutter
import balexiscv.composeapp.generated.resources.flutter_icon
import balexiscv.composeapp.generated.resources.kotlin_icon
import balexiscv.composeapp.generated.resources.nexans_icon
import balexiscv.composeapp.generated.resources.opel_icon
import fr.balexis.cv.model.BaseItemData
import fr.balexis.cv.model.FullItemData

val listSchool = listOf(
    BaseItemData(
        title = "BUT Informatique", description = Res.string.address_iut, date = "2021 - 2024",
    ),
    BaseItemData(
        title = "Baccalauréat", description = Res.string.address_lycee, date = "2018 - 2021",
    ),
)

val listMentoredProject = listOf(
    FullItemData(
        title = "Programmation équipement domotique - IOT",
        date = "",
        tags = listOf("Java", "C", "Android", "Arduino", "MVVM"),
        secondaryText = "IUT Lyon 1",
        mainIcon = Res.drawable.android_icon,
        description = Res.string.description_sae_android
    ), FullItemData(
        title = "Portage d'un jeu AR en Flutter",
        date = "",
        tags = listOf("IOS", "Objective-C", "Flutter", "BLoC"),
        secondaryText = "IUT Lyon 1",
        mainIcon = Res.drawable.flutter_icon,
        description = Res.string.description_sae_flutter
    )

)

val listPersonalProject = listOf(
    FullItemData(
        title = "PokedexPokemon",
        secondaryText = "https://github.com/BlancAlexis/PokedexPokemon",
        date = "",
        tags = listOf(
            "Kotlin", "Clean archi", "Compose", "Koin", "Retrofit", "Room", "Paging 3", "Coil"
        ),
        mainIcon = Res.drawable.android_icon,
        description = Res.string.description_project_pokedex
    ),

    FullItemData(
        title = "Curriculum vitae - CV",
        date = "",
        tags = listOf(
            "KMP", "Android", "IOS", "Web", "Compose multiplatform"
        ),
        description = Res.string.description_project_cv,
        mainIcon = Res.drawable.kotlin_icon,
        secondaryText = "Vous y êtes!"
    ), FullItemData(
        secondaryText = "https://github.com/BlancAlexis/KMP-test",
        title = "App KMP",
        date = "",
        tags = listOf(
            "Kotlin", "Clean archi", "Android", "Ktor", "Room", "Maps", "Koin",
        ),
        description = Res.string.description_project_no_name,
        mainIcon = Res.drawable.kotlin_icon,
    ), FullItemData(
        title = "Guide des monuments de roubaix",
        date = "",
        tags = listOf(
            "Clean archi", "Riverpods", "Maps", "GetIt", "Injectable", "Hive", "Dio"
        ),
        mainIcon = Res.drawable.flutter_icon,
        description = Res.string.description_monuments_of_roubaix
    )
)

val listProfessionalExperience = listOf(
    FullItemData(
        title = "Alternance - Développeur Android",
        date = "Septembre 2023 - 2024",
        tags = listOf(
            "Flavors",
            "Kotlin",
            "Clean Archi",
            "Java",
            "Hilt",
            "Compose",
            "Retrofit",
            "Room",
            "RXJava"
        ),
        secondaryText = "Wimova",
        mainIcon = Res.drawable.android_icon,
        description = Res.string.description_internship_wimova_year
    ), FullItemData(
        title = "Stage - Développeur Android",
        date = "Mai - Juin 2023",
        tags = listOf("Java", "XML", "Volley", "Room"),
        secondaryText = "Wimova",
        mainIcon = Res.drawable.android_icon,
        description = Res.string.description_internship_wimova
    ), FullItemData(
        title = "Intérim - Usine en horaire 3/8",
        date = "Été 2020 - 2023",
        tags = listOf(),
        secondaryText = "Nexans",
        description = Res.string.description_nexans,
        mainIcon = Res.drawable.nexans_icon
    ), FullItemData(
        title = "Alternance - Mécanicien automobile",
        date = "Juin - Août 2020 jusqu'à 2023",
        tags = listOf(),
        secondaryText = "Opel",
        description = Res.string.description_mechanic_internship,
        mainIcon = Res.drawable.opel_icon
    )
)

val libraryKnowAndroidNative = listOf(
    "Retrofit", "Room", "Coroutine", "Flow", "Koin", "RXJava", "Hilt", "Coil", "Paging3", "Maps"
)

val libraryKnowFlutter = listOf(
    "Riverpod", "Bloc", "Hive", "Dio", "Injectable + Get It", "Maps"
)

val libraryKnowKMP = listOf(
    "Ktor", "Kotlin Serialization", "Room", "Koin", "Maps"
)

val listArchi = listOf("MVVM", "MVC", "MVI", "Clean architecture")
