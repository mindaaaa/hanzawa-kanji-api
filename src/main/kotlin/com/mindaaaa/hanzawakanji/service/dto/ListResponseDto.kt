package com.mindaaaa.hanzawakanji.service.dto

import com.mindaaaa.hanzawakanji.db.model.Kanji

data class ListResponseDto(
    val items: List<Kanji>,
    val cursor: Int?,
    val totalCount: Int,
)