package ktfx.stage

import javafx.stage.Stage
import javafx.stage.Window
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.assertEquals

class WindowTest : ApplicationTest() {

    private lateinit var window: Window

    override fun start(stage: Stage) {
        stage.show()
        window = stage
    }

    @Test fun size() {
        window.setSize(500, 250)
        assertEquals(window.width, 500.0)
        assertEquals(window.height, 250.0)
        window.size = 750
        assertEquals(window.width, 750.0)
        assertEquals(window.height, 750.0)
    }
}