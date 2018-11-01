package ktfx

import org.junit.Test
import kotlin.test.assertEquals

class KtfxManagerTest {

    var total = 0
    val manager = object : KtfxManager<Int> {
        @Suppress("FINAL_UPPER_BOUND") override fun <R : Int> R.invoke(): R = also { total += it }
    }

    @Test fun empty() {
        assertEquals(0, total)
        manager.apply {
            1()
            2()
            3()
        }
        assertEquals(6, total)
    }
}