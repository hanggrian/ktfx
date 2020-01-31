package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import org.controlsfx.control.InfoOverlay
import kotlin.test.assertNull

class InfoOverlayTest : LayoutsTest<NodeManager, InfoOverlay>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = infoOverlay { }
    override fun NodeManager.child2() = infoOverlay()
    override fun NodeManager.child3() = infoOverlay { }

    override fun InfoOverlay.testDefaultValues() {
        assertNull(content)
        assertNull(text)
    }
}