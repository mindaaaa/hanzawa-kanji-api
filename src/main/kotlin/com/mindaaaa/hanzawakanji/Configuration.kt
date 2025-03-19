package com.mindaaaa.hanzawakanji

import com.mindaaaa.hanzawakanji.db.KanjiDataSource
import com.mindaaaa.hanzawakanji.persistence.KanjiRepository
import com.mindaaaa.hanzawakanji.persistence.KanjiRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration(
    private val dataSource: KanjiDataSource,
) {
    @Bean
    fun kanjiRepository(): KanjiRepository {
        return KanjiRepositoryImpl(dataSource)
    }
}