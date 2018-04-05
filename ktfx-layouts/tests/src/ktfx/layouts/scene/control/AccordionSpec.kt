package ktfx.layouts.scene.control

import javafx.scene.control.Label
import ktfx.application.initToolkit
import ktfx.layouts.accordion
import ktfx.layouts.label
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@RunWith(JUnitPlatform::class)
object AccordionSpec : Spek({

    given("Accordion") {
        initToolkit()
        it("accordion") {
            val accordion = accordion()
            assertTrue(accordion.panes.isEmpty())
        }
        it("invoke") {
            val accordion = accordion {
                "Hello"()
                "World" {
                    label("haha")
                }
            }
            assertEquals(accordion.panes.size, 2)
            assertTrue(accordion.panes[1].content is Label)
        }
    }
})