package ktfx.jfoenix.coroutines

import com.jfoenix.transitions.JFXAnimationTimer
import kotlinx.coroutines.Dispatchers
import ktfx.jfoenix.test.BaseJFXAnimationTimerTest

class JFXAnimationTimerTest : BaseJFXAnimationTimerTest() {

    override fun JFXAnimationTimer.callOnFinished(action: () -> Unit) =
        onFinished(Dispatchers.Unconfined) { action() }
}
