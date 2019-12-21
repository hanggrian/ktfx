package ktfx.test

import javafx.animation.Animation
import javafx.animation.ScaleTransition
import javafx.event.ActionEvent
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

abstract class BaseAnimationTest {

    abstract fun Animation.callOnFinished(action: (ActionEvent) -> Unit)

    @Test fun onFinished() {
        val scale = ScaleTransition()
        scale.callOnFinished {
            assertEquals(this@BaseAnimationTest, it.source)
            assertNotEquals(FakeEventTarget, it.target)
        }
        scale.onFinished.handle(ActionEvent(this, FakeEventTarget))
    }
}