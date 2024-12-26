package fr.balexis.cv.data

import balexiscv.composeapp.generated.resources.Res
import balexiscv.composeapp.generated.resources.android_icon
import balexiscv.composeapp.generated.resources.flutter_icon
import fr.balexis.cv.model.BaseItemData
import fr.balexis.cv.model.FullItemData

val listSchool = listOf(
    BaseItemData(
        "BUT Informatique", "IUT Lyon 1 - Bourg-en-Bresse", "2021 - 2024"
    ),
    BaseItemData(
        "Baccalauréat", "Lycée carriat - Bourg-en-Bresse", "2018 - 2021"
    ),
)

val listMentoredProject = listOf(
    FullItemData(
        title = "Programmation équipement domotique - IOT",
        description = "Arduino avec plusieurs capteurs biologiques, mesures enregistrées dans une base de données Firebase puis l’application Android interprète sous forme de graphique les données disponibles où que vous soyez en temps réel.",
        date = "",
        tags = listOf("Kotlin", "Java", "Android"),
        companyName = "IUT Lyon 1",
        mainIcon = Res.drawable.android_icon
    ),
    FullItemData(
        title = "Portage d'un jeu AR en Flutter",
        description = "Récupération d’un ancien projet IOS objective-C d’un professeur, portage sur Flutter pour le rendre multiplateforme\n" +
                "avec un système de fichier scénario modifiable à tout moment sans besoin de recompiler",
        date = "",
        tags = listOf("IOS", "Flutter"),
        companyName = "IUT Lyon 1",
        mainIcon = Res.drawable.flutter_icon
    )

)

val listPersonalProject = listOf(
    FullItemData(
        title = "PokedexPokemon",
        description = "Application de consultation du pokedex paginée, mise en db local de groupe de cartes",
        date = "",
        tags = listOf(
            "Flutter",
            "Dart",
            "Clean archi",
            "Android",
            "Riverpods",
            "Maps",
            "GetIt",
            "Injectable",
            "Hive",
            "Dio"
        ),
        mainIcon = Res.drawable.android_icon

    ),
    FullItemData(
        title = "Guide des monuments de roubaix",
        description = "Application permettant la visualisation des monuments et une mise en favori",
        date = "",
        tags = listOf(
            "Kotlin",
            "Clean archi",
            "Android",
            "Compose",
            "Paging 3",
            "Retrofit",
            "Room",
            "Coil"
        ),
        mainIcon = Res.drawable.flutter_icon
    )
)

val listProfesionalExperience = listOf(
    FullItemData(
        title = "Alternance - Développeur Android",
        description = "Développements de nouvelles fonctionnalités\n" +
                "Corrections de bugs \n" +
                "Mise en place d’architecture logicielle \n" +
                "Intégré en équipe suivant une méthode Agile\n" +
                "Test unitaire",
        date = "Septembre 2023 - 2024",
        tags = listOf("Kotlin", "Java", "Android", "Kotlin", "Java", "Android"),
        companyName = "Wimova",
        mainIcon = Res.drawable.android_icon
    ),
    FullItemData(
        title = "Stage - Développeur Android",
        description = "Développements de nouvelles fonctionnalités\n" +
                "Corrections de bugs ",
        "Mai - Juin 2023",
        tags = listOf("Java", "Android", "Clean Archi", "XML", "Volley", "JUnit"),
        companyName = "Wimova",
        mainIcon = Res.drawable.android_icon
    ),
    FullItemData(
        title = "Intérim - Usine en horaire 3/8",
        description = "Travail en équipe",
        date = "Été 2020 - 2023",
        tags = listOf(),
        companyName = "Nexans"
    ),
    FullItemData(
        title = "Alternance - Mécanicien autombile",
        description = "Entretien courant / Tâches plus complexes \n Contact avec les clients ",
        date = "Juin - Août 2020 jusqu'à 2023",
        tags = listOf(),
        companyName = "Nexans"
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