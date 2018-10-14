package ktfx

import com.google.common.truth.Truth
import ktfx.internal.KtfxManager
import org.junit.Test

class ManagerTest {

    @Suppress("FINAL_UPPER_BOUND")
    private val manager = object : KtfxManager<Int> {
        val ints = mutableListOf<Int>()
        override fun <R : Int> R.invoke(): R = also { ints += it }
    }

    @Test fun test() {
        Truth.assertThat(manager.apply {
            1()
            2()
            3()
        }.ints).containsExactly(1, 2, 3)
    }
}