package ktfx.print

import kotlin.test.Test
import kotlin.test.assertEquals

class PageRangeTest {
    @Test
    fun untilPage() {
        val range = 1 untilPage 3
        assertEquals(1, range.startPage)
        assertEquals(3, range.endPage)
    }
}
