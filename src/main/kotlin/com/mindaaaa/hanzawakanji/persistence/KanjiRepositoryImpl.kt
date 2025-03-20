package com.mindaaaa.hanzawakanji.persistence

import com.mindaaaa.hanzawakanji.db.KanjiDataSource
import com.mindaaaa.hanzawakanji.db.model.Kanji
import com.mindaaaa.hanzawakanji.persistence.model.Mode

class KanjiRepositoryImpl(
    private val dataSource: KanjiDataSource,
) : KanjiRepository {
    override fun list(mode: Mode, limit: Int, cursor: Int?): List<Kanji> {
        val data = dataSource.getKanjiList();

        // TODO: mode 기능 구현하기
        // TODO: OutOfBoundException 대응하기
        return if (cursor != null) {
            val startIdx = data.indexOfFirst { it.id == cursor }
            val endIdx = startIdx + limit

            data.subList(startIdx, endIdx)
        } else {
            data.subList(0, 10)
        }
    }
}