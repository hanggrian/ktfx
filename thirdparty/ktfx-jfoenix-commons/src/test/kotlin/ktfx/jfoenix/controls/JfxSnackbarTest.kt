package ktfx.jfoenix.controls

import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.control.Label
import javafx.scene.layout.Pane
import ktfx.time.s
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull

class JfxSnackbarTest {
    @BeforeTest
    fun start() = initToolkit()

    @Test
    fun jfxSnackbar() {
        val pane = Pane()
        assertNotNull(pane.jfxSnackbar.show("Hello world", 5.s))
    }

    @Test
    fun jfxIndefiniteSnackbar() {
        val pane = Pane()
        assertNotNull(pane.jfxSnackbar.showIndefinite(Label("Hello world")))
    }
}
