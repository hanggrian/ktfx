package ktfx

import com.google.common.truth.Truth
import ktfx.internal.Manager
import org.junit.Test

class ManagerTest {

    @Suppress("FINAL_UPPER_BOUND")
    private val manager = Manager.Empty<Int>()

    @Test fun test() {
        Truth.assertThat(manager.apply {
            1()
            2()
            3()
        }.collection).containsExactly(1, 2, 3)
    }
}