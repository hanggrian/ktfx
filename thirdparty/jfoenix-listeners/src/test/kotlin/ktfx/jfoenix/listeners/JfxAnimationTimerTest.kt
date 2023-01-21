package ktfx.jfoenix.listeners

import com.jfoenix.transitions.JFXAnimationTimer
import ktfx.jfoenix.test.BaseJFXAnimationTimerTest

class JfxAnimationTimerTest : BaseJFXAnimationTimerTest() {
    override fun JFXAnimationTimer.callOnFinished(action: () -> Unit): Unit = onFinished(action)
}
