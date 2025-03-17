package com.mindaaaa.hanzawakanji.persistence.model

data class Kanji(
    val id: Int,
    val value: String,
    val reading: String,
    val meaning: String,
    val onyomi: List<String>,
    val kunyomi: List<String>,
    val traditionalForm: String?,
)
