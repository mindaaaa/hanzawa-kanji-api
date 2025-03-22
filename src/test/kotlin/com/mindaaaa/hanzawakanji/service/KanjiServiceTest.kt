package com.mindaaaa.hanzawakanji.service

import com.mindaaaa.hanzawakanji.db.KanjiDataSource
import com.mindaaaa.hanzawakanji.persistence.KanjiRepository
import com.mindaaaa.hanzawakanji.persistence.KanjiRepositoryImpl
import com.mindaaaa.hanzawakanji.persistence.model.Mode
import com.mindaaaa.hanzawakanji.service.dto.ListRequestDto
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class KanjiServiceTest : StringSpec({
    "list() 메소드는 다음 목록이 있는 경우 null이 아닌 cursor를 반환한다." {
        // given
        val dataSource = KanjiDataSource()
        val repository: KanjiRepository = KanjiRepositoryImpl(
            dataSource = dataSource
        )
        val service = KanjiService(repository)

        val request = ListRequestDto(
            mode = Mode.NORMAL,
            limit = 10,
            cursor = null,
            quizId = null,
        )

        // when
        val response = service.list(dto = request)

        // then
        response.cursor shouldNotBe null
        response.items.size shouldBe request.limit
    }

    "list() 메소드는 다음 목록이 없는 경우 cursor를 null로 반환한다." {
        // given
        val dataSource = KanjiDataSource()
        val repository: KanjiRepository = KanjiRepositoryImpl(
            dataSource = dataSource
        )
        val service = KanjiService(repository)

        val request = ListRequestDto(
            mode = Mode.NORMAL,
            limit = 10,
            cursor = 2130,
            quizId = null,
        )

        // when
        val response = service.list(dto = request)

        // then
        response.cursor shouldBe null
        response.items.size shouldBeLessThanOrEqual request.limit!!
    }
})