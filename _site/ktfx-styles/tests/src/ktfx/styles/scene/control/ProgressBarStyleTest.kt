package ktfx.styles.scene.control

import javafx.scene.control.ProgressBar
import ktfx.styles.NodeTest
import ktfx.styles.progressBarStyle

class ProgressBarStyleTest : NodeTest<ProgressBar>() {

    override fun newInstance() = ProgressBar()

    override val style: String
        get() = progressBarStyle(true) {
            indeterminateBarLength = 10
            indeterminateBarEscape = false
            indeterminateBarFlip = false
            indeterminateBarAnimationTime = 5
        }

    override fun ProgressBar.assertion() {
        // assertEquals(isUseSystemMenuBar, true)
    }
}