package ktfx.layouts.scene.control

import javafx.scene.control.Accordion
import javafx.scene.control.Label
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.accordion
import ktfx.layouts.label
import ktfx.layouts.titledPane
import ktfx.test.assertEmpty
import ktfx.test.assertInstance
import kotlin.test.Test
import kotlin.test.assertEquals

class AccordionTest : LayoutTest<NodeManager, Accordion>() {

    override fun createManager() = KtfxPane()
    override fun create() = accordion { }
    override fun NodeManager.add() = accordion()
    override fun NodeManager.addWithBuilder() = accordion { }

    @Test fun stringInvocation() {
        accordion {
            assertEmpty(panes)
            titledPane("Hello")
            "World" {
                label("haha")
            }
            assertEquals(2, panes.size)
            assertInstance<Label>(panes[1].content)
        }
    }
}