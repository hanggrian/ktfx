package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.Hyperlink
import kotlin.test.assertNull

class HyperlinkTest : LayoutsTest<KtfxPane, Hyperlink>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Hyperlink = hyperlink { }

    override fun KtfxPane.child2(): Hyperlink = hyperlink()

    override fun KtfxPane.child3(): Hyperlink = hyperlink { }

    override fun Hyperlink.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
