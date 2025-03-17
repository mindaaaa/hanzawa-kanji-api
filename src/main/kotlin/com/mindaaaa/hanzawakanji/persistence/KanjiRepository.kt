package com.mindaaaa.hanzawakanji.persistence

import com.mindaaaa.hanzawakanji.persistence.model.Kanji
import com.mindaaaa.hanzawakanji.persistence.model.Mode

interface KanjiRepository {
    fun list(mode: Mode, limit: Int, cursor: String?): List<Kanji>
}