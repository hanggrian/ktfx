package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.Accordion
import javafx.scene.control.Label
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AccordionTest : LayoutsTest<KtfxPane, Accordion>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): Accordion = accordion { }
    override fun KtfxPane.child2(): Accordion = accordion()
    override fun KtfxPane.child3(): Accordion = accordion { }

    @Test
    fun stringInvocation() {
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
