package com.mindaaaa.hanzawakanji.persistence

import com.mindaaaa.hanzawakanji.db.model.Kanji
import com.mindaaaa.hanzawakanji.persistence.model.Mode

interface KanjiRepository {
    fun list(mode: Mode, limit: Int, cursor: Int?, quizId: String?): List<Kanji>
    fun getTotalCount(): Int
}