package ktfx.layouts.scene.control

import javafx.scene.control.Label
import ktfx.layouts.NodeManager
import ktfx.layouts.KtfxPane
import ktfx.layouts.accordion
import ktfx.layouts.label
import ktfx.layouts.titledPane
import ktfx.test.LayoutToolkitTest
import ktfx.test.assertEmpty
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AccordionTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        accordion {
            assertEmpty(panes)
            titledPane("Hello")
            "World" {
                label("haha")
            }
            assertEquals(2, panes.size)
            assertTrue(panes[1].content is Label)
        }
    }
}