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
        // TODO: OutOfBoundException 대응하기
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

        val random = Random(seed.hashCode())

        return data.shuffled(random)
    }

    private fun sliceList(target: List<Kanji>, limit: Int, cursor: Int?): List<Kanji> {
        return if (cursor != null) {
            val startIdx = target.indexOfFirst { it.id == cursor }
            val endIdx = startIdx + limit

            target.subList(startIdx, endIdx)
        } else {
            target.subList(0, 10)
        }
    }
}