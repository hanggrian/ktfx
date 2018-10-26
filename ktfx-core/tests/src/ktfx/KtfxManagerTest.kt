package ktfx

import com.google.common.truth.Truth
import ktfx.internal.KtfxManager
import org.junit.Test

class KtfxManagerTest {

    private val manager = KtfxManager.empty<Int>()

    @Test fun test() {
        Truth.assertThat(manager.apply {
            1()
            2()
            3()
        }.collection).containsExactly(1, 2, 3)
    }
}