package ktfx.scene.text

import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.stage.Stage
import ktfx.test.AppTest
import org.junit.Test
import kotlin.test.assertEquals

class LabeledTest : AppTest() {

    private lateinit var label: Label

    override fun start(stage: Stage) {
        label = Label("Hello world")
        stage.run {
            scene = Scene(label)
            show()
        }
    }

    @Test fun fontSize() {
        label.fontSize = 1.0
        assertEquals(1.0, label.fontSize)
    }

    @Test fun fontFamily() {
        label.fontFamily = "Arial"
        assertEquals("Arial", label.fontFamily)
    }
}