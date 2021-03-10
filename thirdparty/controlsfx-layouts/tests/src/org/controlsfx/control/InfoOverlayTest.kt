package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.InfoOverlay
import kotlin.test.assertNull

class InfoOverlayTest : LayoutsTest<KtfxPane, InfoOverlay>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = infoOverlay { }
    override fun KtfxPane.child2() = infoOverlay()
    override fun KtfxPane.child3() = infoOverlay { }

    override fun InfoOverlay.testDefaultValues() {
        assertNull(content)
        assertNull(text)
    }
}