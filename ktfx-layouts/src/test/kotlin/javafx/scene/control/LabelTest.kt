package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.Label
import kotlin.test.assertNull

class LabelTest : LayoutsStyledTest<KtfxPane, Label>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = label {}

    override fun KtfxPane.child2() = label()

    override fun child3() = styledLabel()

    override fun KtfxPane.child4() = styledLabel()

    override fun Label.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
