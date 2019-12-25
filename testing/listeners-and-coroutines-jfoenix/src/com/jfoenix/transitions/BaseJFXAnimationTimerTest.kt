package ktfx.jfoenix.test

import com.jfoenix.transitions.JFXAnimationTimer
import ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test

abstract class BaseJFXAnimationTimerTest {

    abstract fun JFXAnimationTimer.callOnFinished(action: () -> Unit)

    private lateinit var timer: JFXAnimationTimer

    @BeforeTest fun start() {
        initToolkit()
        timer = JFXAnimationTimer()
    }

    @Test fun onFinished() {
        timer.callOnFinished { }
    }
}