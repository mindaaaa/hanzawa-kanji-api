package com.mindaaaa.hanzawakanji.persistence

import com.mindaaaa.hanzawakanji.db.KanjiDataSource
import com.mindaaaa.hanzawakanji.persistence.model.Mode
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class KanjiRepositoryImplTest : StringSpec({
    "list() 메소드는 mode 값에 따라 섞이거나 섞이지 않은 Kanji 리스트를 반환한다." {
        // given
        val limit = 10
        val kanjiRepository: KanjiRepository = KanjiRepositoryImpl(
            dataSource = KanjiDataSource(),
        )

        // when
        val normalList = kanjiRepository.list(Mode.NORMAL, limit, null, null)
        val shuffledList = kanjiRepository.list(Mode.RANDOM, limit, null, null)

        // then
        normalList shouldNotBe shuffledList
    }

    "list() 메소드에 RANDOM 모드를 전달한 경우, 인자에 전달된 id에 따라 항상 동일한 결과를 반환할 수 있어야 한다." {
        // given
        val id = "hello world"
        val limit = 10
        val kanjiRepository: KanjiRepository = KanjiRepositoryImpl(
            dataSource = KanjiDataSource(),
        )

        // when
        val first = kanjiRepository.list(Mode.RANDOM, limit, null, id)
        val second = kanjiRepository.list(Mode.RANDOM, limit, null, id)

        // then
        first shouldBe second
    }
})