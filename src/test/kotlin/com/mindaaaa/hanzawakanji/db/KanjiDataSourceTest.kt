package com.mindaaaa.hanzawakanji.db

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class KanjiDataSourceTest : StringSpec({
    "getKanjiList() 메소드는 id를 기준으로 정렬된 Kanji 리스트를 반환한다." {
        // given
        val dataSource = KanjiDataSource()

        // when
        val kanjiList = dataSource.getKanjiList()
        val idSortedList = kanjiList.sortedBy { kanji -> kanji.id }

        // then
        kanjiList shouldBe idSortedList
    }
})