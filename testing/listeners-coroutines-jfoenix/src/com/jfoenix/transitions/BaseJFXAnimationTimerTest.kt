package ktfx.jfoenix.test

import com.jfoenix.transitions.JFXAnimationTimer
import io.github.hendraanggrian.ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test

abstract class BaseJFXAnimationTimerTest {
    private lateinit var timer: JFXAnimationTimer

    abstract fun JFXAnimationTimer.callOnFinished(action: () -> Unit)

    @BeforeTest fun start() {
        initToolkit()
        timer = JFXAnimationTimer()
    }

    @Test fun onFinished() {
        timer.callOnFinished { }
    }
}