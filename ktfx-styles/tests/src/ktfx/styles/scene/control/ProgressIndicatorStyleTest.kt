package ktfx.styles.scene.control

import javafx.scene.control.ProgressIndicator
import javafx.scene.paint.Color.BLUE
import ktfx.styles.NodeTest
import ktfx.styles.progressIndicatorStyle

class ProgressIndicatorStyleTest : NodeTest<ProgressIndicator>() {

    override fun newInstance() = ProgressIndicator()

    override val style: String
        get() = progressIndicatorStyle {
            // progressColor = BLUE
        }

    override fun ProgressIndicator.assertion() {
        // assertEquals(isUseSystemMenuBar, true)
    }
}