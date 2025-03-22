package com.mindaaaa.hanzawakanji.service.dto

import com.mindaaaa.hanzawakanji.persistence.model.Mode

data class ListRequestDto(
    val mode: Mode?,
    val limit: Int?,
    val cursor: Int?,
    val quizId: String?,
)