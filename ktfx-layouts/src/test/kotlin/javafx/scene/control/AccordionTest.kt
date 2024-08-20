package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.Accordion
import javafx.scene.control.Label
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class AccordionTest : LayoutsStyledTest<KtfxPane, Accordion>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = accordion {}

    override fun KtfxPane.child2() = accordion()

    override fun child3() = styledAccordion()

    override fun KtfxPane.child4() = styledAccordion()

    @Test
    fun stringInvocation() {
        accordion {
            assertThat(panes).isEmpty()
            titledPane("Hello")
            "World" {
                label("haha")
            }
            assertEquals(2, panes.size)
            assertIs<Label>(panes.last().content)
        }
    }
}
