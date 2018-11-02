package ktfx

import org.junit.Test
import kotlin.test.assertEquals

class KtfxInvokableTest {

    var total = 0
    val invokable = object : KtfxInvokable<Int> {
        @Suppress("FINAL_UPPER_BOUND") override fun <R : Int> R.invoke(): R = also { total += it }
    }

    @Test fun empty() {
        assertEquals(0, total)
        invokable.apply {
            1()
            2()
            3()
        }
        assertEquals(6, total)
    }
}