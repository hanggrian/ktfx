package ktfx.layouts

import com.google.common.truth.Truth
import org.junit.Test

class LayoutManagerTest {

    private val manager = object : LayoutManager<Int> {
        override val childs: MutableCollection<Int> = mutableListOf()
    }

    @Test fun test() {
        Truth.assertThat(manager.apply {
            1()
            2()
            3()
        }.childs).containsExactly(1, 2, 3)
    }
}