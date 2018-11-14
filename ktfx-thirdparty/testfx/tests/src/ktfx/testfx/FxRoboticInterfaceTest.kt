package ktfx.testfx

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.input.MouseButton
import javafx.stage.Stage
import ktfx.layouts.button
import ktfx.layouts.label
import ktfx.layouts.scene
import ktfx.layouts.vbox
import ktfx.test.AppTest
import org.junit.Test
import kotlin.test.assertEquals

class FxRoboticInterfaceTest : AppTest() {

    private lateinit var label: Label
    private lateinit var button: Button

    override fun start(stage: Stage) {
        stage.scene = scene {
            vbox {
                label = label()
                button = button("Tap here") {
                    setOnAction {
                        label.text = "${label.text.orEmpty()}A"
                    }
                }
            }
        }
        stage.show()
    }

    @Test fun buttonClick() {
        moveTo(button) press MouseButton.PRIMARY release MouseButton.PRIMARY
        assertEquals("A", label.text)
    }
}