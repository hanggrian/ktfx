package ktfx.layouts

import org.junit.Test
import kotlin.test.assertEquals

class LayoutManagerTest {

    var total = 0
    val invokable = object : LayoutManager<Int> {
        @Suppress("FINAL_UPPER_BOUND") override fun <R : Int> R.add(): R = also { total += it }
    }

    @Test fun empty() {
        assertEquals(0, total)
        invokable.apply {
            1.add()
            2.add()
            3.add()
        }
        assertEquals(6, total)
    }
}