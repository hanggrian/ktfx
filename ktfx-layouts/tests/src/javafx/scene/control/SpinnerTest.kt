package ktfx.layouts

import javafx.scene.control.Spinner
import ktfx.test.BaseLayoutTest

class SpinnerTest : BaseLayoutTest<NodeManager, Spinner<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = spinner<String> { }
    override fun NodeManager.child2() = spinner<String>()
    override fun NodeManager.child3() = spinner<String> { }
}