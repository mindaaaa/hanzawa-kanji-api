package com.mindaaaa.hanzawakanji.presentation

import com.mindaaaa.hanzawakanji.persistence.model.Mode
import com.mindaaaa.hanzawakanji.service.KanjiService
import com.mindaaaa.hanzawakanji.service.dto.ListRequestDto
import com.mindaaaa.hanzawakanji.service.dto.ListResponseDto
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/hanzawa-kanji")
class KanjiController(
    private val service: KanjiService,
) {
    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun list(
        @RequestParam mode: Mode?,
        @RequestParam limit: Int?,
        @RequestParam cursor: Int?,
        @RequestParam quizId: String?,
    ): ResponseEntity<ListResponseDto> {
        val response = service.list(
            dto = ListRequestDto(
                mode = mode,
                limit = limit,
                cursor = cursor,
                quizId = quizId,
            )
        )

        return ResponseEntity.ok(response)
    }
}