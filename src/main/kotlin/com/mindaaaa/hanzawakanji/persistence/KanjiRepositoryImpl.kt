package com.mindaaaa.hanzawakanji.persistence

import com.mindaaaa.hanzawakanji.db.KanjiDataSource
import com.mindaaaa.hanzawakanji.db.model.Kanji
import com.mindaaaa.hanzawakanji.persistence.model.Mode

class KanjiRepositoryImpl(
    private val dataSource: KanjiDataSource,
) : KanjiRepository {
    override fun list(mode: Mode, limit: Int, cursor: String?): List<Kanji> {
        TODO("Not yet implemented")
    }
}