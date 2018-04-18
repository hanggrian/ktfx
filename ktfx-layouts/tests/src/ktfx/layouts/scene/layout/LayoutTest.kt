package ktfx.layouts.scene.layout

import javafx.scene.control.Label
import ktfx.application.initToolkit
import ktfx.layouts.label
import ktfx.layouts.vbox
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LayoutTest {

    @Before fun init() = initToolkit()

    @Test fun add() {
        val layout = vbox {
            label()
        }
        assertEquals(layout.children.size, 1)
        assertTrue(layout.children.last() is Label)
    }
}