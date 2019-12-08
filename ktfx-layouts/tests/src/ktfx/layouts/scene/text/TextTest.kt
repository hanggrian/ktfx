package ktfx.layouts.scene.text

import javafx.scene.text.Text
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.text
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class TextTest : LayoutTest<NodeManager, Text>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = text { }
    override fun NodeManager.child2() = text()
    override fun NodeManager.child3() = text { }

    override fun Text.testDefaultValues() {
        assertNull(text)
    }
}