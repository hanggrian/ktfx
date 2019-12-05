package ktfx.layouts.scene.text

import javafx.scene.text.Text
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.text
import kotlin.test.assertNull

class TextTest : LayoutTest<NodeManager, Text>() {

    override fun createManager() = KtfxPane()
    override fun create() = text { }
    override fun NodeManager.add() = text()
    override fun NodeManager.addWithBuilder() = text { }

    override fun Text.testDefaultValues() {
        assertNull(text)
    }
}