package com.mindaaaa.hanzawakanji.db

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mindaaaa.hanzawakanji.db.model.Kanji
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.nio.file.Files

@Component
class KanjiDataSource {
    companion object {
        private const val JSON_FILE_PATH = "data.json"
    }

    private val data: List<Kanji> = init()

    private fun init(): List<Kanji> {
        val json = Files.readString(ClassPathResource(JSON_FILE_PATH).file.toPath(), Charsets.UTF_8)

        val jackson = jacksonObjectMapper()
        return jackson.readValue(json, object: TypeReference<List<Kanji>>(){})
    }

    fun getKanjiList(): List<Kanji> {
        return data
    }
}
