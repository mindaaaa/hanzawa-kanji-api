package com.mindaaaa.hanzawakanji.persistence

import com.mindaaaa.hanzawakanji.db.KanjiDataSource
import com.mindaaaa.hanzawakanji.db.model.Kanji
import com.mindaaaa.hanzawakanji.persistence.model.Mode

class KanjiRepositoryImpl(
    private val dataSource: KanjiDataSource,
) : KanjiRepository {
    override fun list(mode: Mode, limit: Int, cursor: String?): List<Kanji> {
        TODO("Not yet implemented")
        // 1. dataSource로부터 한자 목록을 가져온다

        // 2. mode에 따라 섞거나 섞지 않는다

        // 3. cursor와 limit에 따라 2.의 결과를 잘라 반환한다.
    }
}