package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.Accordion
import javafx.scene.control.Label
import ktfx.test.LayoutsTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AccordionTest : LayoutsTest<NodeManager, Accordion>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = accordion { }
    override fun NodeManager.child2() = accordion()
    override fun NodeManager.child3() = accordion { }

    @Test fun stringInvocation() {
        accordion {
            assertThat(panes).isEmpty()
            titledPane("Hello")
            "World" {
                label("haha")
            }
            assertEquals(2, panes.size)
            assertTrue(panes[1].content is Label)
        }
    }
}