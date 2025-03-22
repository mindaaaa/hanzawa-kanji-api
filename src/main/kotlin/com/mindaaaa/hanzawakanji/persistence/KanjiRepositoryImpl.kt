package com.mindaaaa.hanzawakanji.persistence

import com.mindaaaa.hanzawakanji.db.KanjiDataSource
import com.mindaaaa.hanzawakanji.db.model.Kanji
import com.mindaaaa.hanzawakanji.persistence.model.Mode
import java.util.*
import kotlin.random.Random

class KanjiRepositoryImpl(
    private val dataSource: KanjiDataSource,
) : KanjiRepository {
    override fun list(mode: Mode, limit: Int, cursor: Int?, quizId: String?): List<Kanji> {
        val data = decideData(
            data = dataSource.getKanjiList(),
            mode = mode,
            quizId = quizId,
        )

        return sliceList(data, limit, cursor)
    }

    private fun decideData(data: List<Kanji>, mode: Mode, quizId: String?): List<Kanji> {
        if (mode == Mode.NORMAL) {
            return data
        }

        val seed = quizId ?: UUID.randomUUID().toString()

        return data.shuffled(
            random = Random(seed.hashCode()),
        )
    }

    private fun sliceList(target: List<Kanji>, limit: Int, cursor: Int?): List<Kanji> {
        if (cursor == null) {
            return target.subList(0, limit)
        }

        val startIdx = target.indexOfFirst { it.id == cursor }
        if (startIdx == -1) {
            return emptyList()
        }

        val endIdx = startIdx + limit
        if (endIdx > target.size) {
            return target.subList(startIdx, target.size)
        }

        return target.subList(startIdx, endIdx)
    }

    override fun getTotalCount(): Int {
        return dataSource.getKanjiList()
            .size
    }
}