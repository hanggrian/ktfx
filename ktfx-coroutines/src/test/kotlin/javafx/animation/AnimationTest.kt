package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import javafx.animation.ScaleTransition
import javafx.event.ActionEvent
import kotlinx.coroutines.Dispatchers
import kotlin.test.Test
import kotlin.test.assertEquals

class AnimationTest {
    @Test
    fun onFinished() {
        val scale = ScaleTransition()
        scale.onFinished(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        scale.onFinished.handle(ActionEvent(this, FakeEventTarget))
    }
}
