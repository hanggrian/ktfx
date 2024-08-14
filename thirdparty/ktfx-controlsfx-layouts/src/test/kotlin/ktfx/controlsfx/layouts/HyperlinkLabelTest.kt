package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.HyperlinkLabel
import kotlin.test.assertNull

class HyperlinkLabelTest : LayoutsStyledTest<KtfxPane, HyperlinkLabel>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = hyperlinkLabel {}

    override fun KtfxPane.child2() = hyperlinkLabel()

    override fun child3() = styledHyperlinkLabel(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledHyperlinkLabel(styleClass = arrayOf("style"))

    override fun HyperlinkLabel.testDefaultValues() {
        assertNull(text)
    }
}
