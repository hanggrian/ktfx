package ktfx.dialogs

import javafx.scene.image.ImageView
import javafx.stage.Stage
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import ktfx.test.BaseDialogTest
import ktfx.test.assertInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.testfx.api.FxRobot
import org.testfx.framework.junit5.ApplicationExtension
import org.testfx.framework.junit5.Start

@Ignore
@ExtendWith(ApplicationExtension::class)
class InputDialogTest : BaseDialogTest() {

    @Start override fun start(stage: Stage) = super.start(stage)

    @Test fun FxRobot.inputDialog() {
        interact {
            assertEquals("Awesome input", inputDialog("Input dialog", ImageView("file:icon.png"), "Awful input") {
                closeOnShow(this)
                assertEquals("Input dialog", headerText)
                assertInstance<ImageView>(graphic)
                assertEquals("Awful input", defaultValue)
                editor.text = "Awesome input"
            }.get())
            assertEquals("Awesome input", inputDialog("Awful input") {
                closeOnShow(this)
                assertEquals("Awful input", defaultValue)
                editor.text = "Awesome input"
            }.get())
        }
    }
}
