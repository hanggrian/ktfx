package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.Label
import kotlin.test.assertNull

class LabelTest : LayoutsTest<KtfxPane, Label>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Label = label { }

    override fun KtfxPane.child2(): Label = label()

    override fun KtfxPane.child3(): Label = label { }

    override fun Label.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
