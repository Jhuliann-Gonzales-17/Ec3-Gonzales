package com.monica.ec3_monica_gonzales_.model

data class List_(
    val anime_name: String,
    val url: String,
)
fun getData():List<List_> =
    listOf(
        List_("","Bank Warda"),
        List_("","Bank Warda"),
    )