package ktfx.listeners

import javafx.animation.ScaleTransition
import kotlin.test.Test

class AnimationTest {

    @Test fun onFinished() {
        val scale = ScaleTransition()
        scale.onFinished {

        }
    }
}