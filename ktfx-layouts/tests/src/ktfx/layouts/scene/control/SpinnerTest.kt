package ktfx.layouts.scene.control

import javafx.scene.control.Spinner
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.spinner

class SpinnerTest : LayoutTest<NodeManager, Spinner<String>>() {

    override fun createManager() = KtfxPane()
    override fun create() = spinner<String> { }
    override fun NodeManager.add() = spinner<String>()
    override fun NodeManager.addWithBuilder() = spinner<String> { }
}