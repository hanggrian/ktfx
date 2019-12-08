package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import org.controlsfx.control.HyperlinkLabel
import org.controlsfx.control.InfoOverlay
import org.controlsfx.control.PlusMinusSlider
import kotlin.test.assertNull

class PlusMinusSliderTest : LayoutTest<NodeManager, PlusMinusSlider>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = plusMinusSlider { }
    override fun NodeManager.child2() = plusMinusSlider()
    override fun NodeManager.child3() = plusMinusSlider { }
}