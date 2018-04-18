package ktfx.layouts.scene.control

import javafx.scene.control.Label
import ktfx.application.initToolkit
import ktfx.layouts.label
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AccordionTest {

    @Before fun init() = initToolkit()

    @Test fun accordion() {
        val accordion = ktfx.layouts.accordion()
        assertTrue(accordion.panes.isEmpty())
    }

    @Test fun invoke() {
        val accordion = ktfx.layouts.accordion {
            "Hello"()
            "World" {
                label("haha")
            }
        }
        assertEquals(accordion.panes.size, 2)
        assertTrue(accordion.panes[1].content is Label)
    }
}