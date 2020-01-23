package ktfx.test

import javafx.animation.Animation
import javafx.animation.ScaleTransition
import javafx.event.ActionEvent
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseAnimationTest {

    abstract fun Animation.callOnFinished(action: (ActionEvent) -> Unit)

    @Test fun onFinished() {
        val scale = ScaleTransition()
        scale.callOnFinished {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        scale.onFinished.handle(ActionEvent(this, FakeEventTarget))
    }
}