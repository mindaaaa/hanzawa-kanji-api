package com.mindaaaa.hanzawakanji.db.model

data class Kanji(
    val id: Int,
    val value: String,
    val korean: List<Reading>,
    val kunyomi: List<String>,
    val onyomi: List<String>,
    val traditionalForm: String?,
) {
    data class Reading(
        val kun: String,
        val on: String,
    )
}