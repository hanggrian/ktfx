package ktfx.layouts

import javafx.scene.control.Hyperlink
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class HyperlinkTest : LayoutsTest<KtfxPane, Hyperlink>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = hyperlink { }
    override fun KtfxPane.child2() = hyperlink()
    override fun KtfxPane.child3() = hyperlink { }

    override fun Hyperlink.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}