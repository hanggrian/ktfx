package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.Hyperlink
import kotlin.test.assertNull

class HyperlinkTest : LayoutsStyledTest<KtfxPane, Hyperlink>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = hyperlink {}

    override fun KtfxPane.child2() = hyperlink()

    override fun child3() = styledHyperlink(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledHyperlink(styleClass = arrayOf("style"))

    override fun Hyperlink.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
