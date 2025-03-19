package com.mindaaaa.hanzawakanji.db

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class KanjiDataSourceTest {

  @Test
  fun `KanjiDataSource를 인스턴스화 후에는 프로퍼티를 통해 한자 목록을 접근할 수 있다`() {
   val dataSource = KanjiDataSource()

   assertTrue(dataSource.data.size == 3)
  }
 }