package ktfx.layouts.scene.control

import javafx.scene.control.Spinner
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.spinner
import ktfx.test.LayoutTest

class SpinnerTest : LayoutTest<NodeManager, Spinner<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = spinner<String> { }
    override fun NodeManager.child2() = spinner<String>()
    override fun NodeManager.child3() = spinner<String> { }
}