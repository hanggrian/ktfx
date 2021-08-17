package ktfx.jfoenix.controls

import javafx.scene.layout.Pane
import com.hendraanggrian.ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull

class JFXSnackbarTest {

    @BeforeTest fun start() = initToolkit()

    @Test
    fun jfxSnackbar() {
        val pane = Pane()
        assertNotNull(pane.jfxSnackbar("Hello world", 500, "Close") { })
        assertNotNull(pane.jfxSnackbar("Hello world", 1000))
    }

    @Test
    fun jfxIndefiniteSnackbar() {
        val pane = Pane()
        assertNotNull(pane.jfxIndefiniteSnackbar("Hello world", "Close") { })
        assertNotNull(pane.jfxIndefiniteSnackbar("Hello world"))
    }
}