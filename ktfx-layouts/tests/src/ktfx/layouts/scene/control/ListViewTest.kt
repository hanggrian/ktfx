package ktfx.layouts.scene.control

import javafx.scene.control.ListView
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.listView
import ktfx.test.assertEmpty

class ListViewTest : LayoutTest<NodeManager, ListView<String>>(KtfxPane()) {

    override fun create() = listView<String> { }
    override fun NodeManager.add() = listView<String>()
    override fun NodeManager.addWithBuilder() = listView<String> { }

    override fun ListView<String>.testDefaultValues() {
        assertEmpty(items)
    }
}