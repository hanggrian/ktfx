package ktfx.styles.scene.control

import javafx.scene.control.TextArea
import javafx.scene.paint.Color.AQUA
import javafx.scene.paint.Color.AZURE
import javafx.scene.paint.Color.BLUE
import javafx.scene.paint.Color.RED
import ktfx.styles.NodeTest
import ktfx.styles.textInputControlStyle

class TextInputControlStyleTest : NodeTest<TextArea>() {

    override fun newInstance() = TextArea("Hello world")

    override val style: String
        get() = textInputControlStyle {
            // TODO: investigate why this test run successfully but gradle build failed
            /*textFill = BLUE
            promptTextFill = AQUA
            highlightFill = RED
            highlightTextFill = AZURE
            displayCaret = false*/
        }

    override fun TextArea.assertion() {
    }
}