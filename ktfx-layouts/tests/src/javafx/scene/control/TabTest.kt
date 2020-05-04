package ktfx.layouts

import javafx.scene.control.Tab
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class TabTest : LayoutsTest<KtfxTabPane, Tab>() {

    override fun manager() = KtfxTabPane()
    override fun KtfxTabPane.childCount() = tabs.size
    override fun child1() = tab { }
    override fun KtfxTabPane.child2() = tab()
    override fun KtfxTabPane.child3() = tab { }

    override fun Tab.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}