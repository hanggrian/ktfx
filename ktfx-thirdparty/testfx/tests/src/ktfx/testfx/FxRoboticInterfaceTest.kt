package ktfx.testfx

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Stage
import ktfx.layouts.button
import ktfx.layouts.label
import ktfx.layouts.scene
import ktfx.layouts.vbox
import ktfx.test.AppTest
import org.junit.Test
import org.testfx.api.FxAssert
import org.testfx.matcher.control.LabeledMatchers
import org.testfx.util.WaitForAsyncUtils

class FxRoboticInterfaceTest : AppTest() {

    private lateinit var label: Label
    private lateinit var button: Button

    override fun start(stage: Stage) {
        stage.scene = scene {
            vbox {
                label = label("Tap here.")
                button = button("Tap") {
                    setOnAction {
                        label.text = "Tapped."
                    }
                }
            }
        }
        stage.show()
    }

    @Test
    fun buttonClick() {
         clickOn(button)
        //moveTo(button) press MouseButton.PRIMARY release MouseButton.PRIMARY moveTo Point2D(0.0, 0.0)
        WaitForAsyncUtils.waitForFxEvents()
        FxAssert.verifyThat(label, LabeledMatchers.hasText("Tapped."))
        // assertEquals("Tapped.", label.text)
    }
}