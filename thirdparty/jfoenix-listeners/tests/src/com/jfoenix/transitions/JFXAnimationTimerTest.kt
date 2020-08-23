package ktfx.jfoenix.listeners

import com.jfoenix.transitions.JFXAnimationTimer
import ktfx.jfoenix.test.BaseJFXAnimationTimerTest

class JFXAnimationTimerTest : BaseJFXAnimationTimerTest() {

    override fun JFXAnimationTimer.callOnFinished(action: () -> Unit) = onFinished(action)
}