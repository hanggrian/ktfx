package ktfx.jfoenix.coroutines

import com.jfoenix.transitions.JFXAnimationTimer
import kotlinx.coroutines.Dispatchers
import ktfx.jfoenix.test.BaseJFXAnimationTimerTest

class JfxAnimationTimerTest : BaseJFXAnimationTimerTest() {
    override fun JFXAnimationTimer.callOnFinished(action: () -> Unit): Unit =
        onFinished(Dispatchers.Unconfined) { action() }
}
