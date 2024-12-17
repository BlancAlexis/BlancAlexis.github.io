package fr.balexis.cv.data

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
        "Programmation équipement domotique - IOT",
        "Arduino avec plusieurs capteurs biologiques, mesures enregistrées dans une base de données Firebase puis l’application Android interprète sous forme de graphique les données disponibles où que vous soyez en temps réel.",
        "",
        listOf("Kotlin", "Java", "Android"),
        "IUT Lyon 1"
    ),
    FullItemData(
        "Portage d'un jeu AR en Flutter",
        "Récupération d’un ancien projet IOS objective-C d’un professeur, portage sur Flutter pour le rendre multiplateforme\n" +
                "avec un système de fichier scénario modifiable à tout moment sans besoin de recompiler",
        "",
        listOf("IOS", "Flutter"),
        "IUT Lyon 1"
    )

)

val listPersonalProject = listOf(
    FullItemData(
        "PokedexPokemon",
        "Application de consultation du pokedex paginée, mise en db local de groupe de cartes",
        "",
        listOf(
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
        "IUT Lyon 1"
    ),
    FullItemData(
        "Guide des monuments de roubaix",
        "Application permettant la visualisation des monuments et une mise en favori",
        "",
        listOf(
            "Kotlin",
            "Clean archi",
            "Android",
            "Compose",
            "Paging 3",
            "Retrofit",
            "Room",
            "Coil"
        ),
        "IUT Lyon 1"
    )
)

val listProfesionalExperience = listOf(
    FullItemData(
        "Alternance - Développeur Android",
        "Développements de nouvelles fonctionnalités\n" +
                "Corrections de bugs \n" +
                "Mise en place d’architecture logicielle \n" +
                "Intégré en équipe suivant une méthode Agile\n" +
                "Test unitaire",
        "Septembre 2023 - 2024",
        listOf("Kotlin", "Java", "Android", "Kotlin", "Java", "Android"),
        "Wimova"
    ),
    FullItemData(
        "Stage - Développeur Android",
        "Développements de nouvelles fonctionnalités\n" +
                "Corrections de bugs ",
        "Mai - Juin 2023",
        listOf("Java", "Android", "Clean Archi", "XML", "Volley", "JUnit"),
        "Wimova"
    ),
    FullItemData(
        "Intérim - Travailler métallurgie en horaire 3/8",
        "Travail en équipe",
        "Juin - Août 2020 jusqu'à 2023",
        listOf(),
        "Nexans"
    ),
    FullItemData(
        "Alternance - Mécanicien autombile",
        "Entretien courant / Tâches plus complexes \n Contact avec les clients ",
        "Juin - Août 2020 jusqu'à 2023",
        listOf(),
        "Nexans"
    )
)

open class BaseItemData(
    open val title : String,
    open val description : String,
    open val date : String
)

data class FullItemData(
    override val title : String,
    override val description : String,
    override val date : String,
    val tags : List<String>,
    val companyName : String = ""
) : BaseItemData(title, description, date) {

}