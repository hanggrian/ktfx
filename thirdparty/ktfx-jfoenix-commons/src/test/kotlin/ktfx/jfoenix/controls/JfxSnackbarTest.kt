package ktfx.jfoenix.controls

import com.hanggrian.ktfx.test.testScene
import com.jfoenix.controls.JFXSnackbar
import com.jfoenix.controls.JFXSnackbarLayout
import javafx.scene.control.Label
import javafx.scene.layout.Pane
import javafx.stage.Stage
import ktfx.time.s
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull

class JfxSnackbarTest : ApplicationTest() {
    lateinit var pane: Pane

    override fun start(stage: Stage) {
        stage.testScene<JFXSnackbar>()
        pane = Pane()
    }

    @Test
    fun jfxSnackbar() {
        assertNotNull(pane.jfxSnackbar)
        assertEquals(50.0, pane.jfxSnackbar { prefWidth = 50.0 }.prefWidth)
    }

    @Test
    fun show() {
        val snackbar = pane.jfxSnackbar
        snackbar.show("Hello world", 5.s)
        interact {
            assertIs<JFXSnackbarLayout>(snackbar.currentEvent.content)
        }
    }

    @Test
    fun showIndefinite() {
        val snackbar = pane.jfxSnackbar
        snackbar.showIndefinite(Label("Hello world"))
        interact {
            assertIs<Label>(snackbar.currentEvent.content)
        }
    }
}
