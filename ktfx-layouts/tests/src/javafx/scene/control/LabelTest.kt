package ktfx.layouts

import javafx.scene.control.Label
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class LabelTest : LayoutsTest<KtfxPane, Label>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = label { }
    override fun KtfxPane.child2() = label()
    override fun KtfxPane.child3() = label { }

    override fun Label.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}