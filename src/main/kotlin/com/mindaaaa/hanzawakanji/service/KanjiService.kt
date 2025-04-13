package com.mindaaaa.hanzawakanji.service

import com.mindaaaa.hanzawakanji.persistence.KanjiRepository
import com.mindaaaa.hanzawakanji.persistence.model.Mode
import com.mindaaaa.hanzawakanji.service.dto.ListRequestDto
import com.mindaaaa.hanzawakanji.service.dto.ListResponseDto
import org.springframework.stereotype.Service

@Service
class KanjiService(
    private val repository: KanjiRepository,
) {
    companion object {
        private val DEFAULT_MODE: Mode = Mode.NORMAL
        private const val DEFAULT_LIMIT: Int = 10
        private const val DEFAULT_CURSOR: Int = 1
    }

    fun list(dto: ListRequestDto): ListResponseDto {
        val limit = dto.limit ?: DEFAULT_LIMIT

        val refinedLimit = limit + 1
        val mode = dto.mode ?: DEFAULT_MODE
        
        val cursor: Int? = if (dto.cursor == null && dto.mode == Mode.NORMAL) {
            DEFAULT_CURSOR
        } else {
            dto.cursor
        }

        val kanjiList = repository.list(
            limit = refinedLimit,
            quizId = dto.quizId,
            mode = mode,
            cursor = cursor,
        )
        val totalCount = repository.getTotalCount()

        return if (kanjiList.size == refinedLimit) {
            val lastOne = kanjiList.last()
            val items = kanjiList.take(limit)

            ListResponseDto(items, lastOne.id, totalCount)
        } else {
            ListResponseDto(kanjiList, null, totalCount)
        }
    }
}