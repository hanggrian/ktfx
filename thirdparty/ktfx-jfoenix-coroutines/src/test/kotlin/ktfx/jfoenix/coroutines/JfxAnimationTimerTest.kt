package ktfx.jfoenix.coroutines

import com.hanggrian.ktfx.test.initToolkit
import com.jfoenix.transitions.JFXAnimationTimer
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test

class JfxAnimationTimerTest {
    private lateinit var timer: JFXAnimationTimer

    @BeforeTest fun start() {
        initToolkit()
        timer = JFXAnimationTimer()
    }

    @Test
    fun onFinished() {
        timer.onFinished(Dispatchers.Unconfined) {}
    }
}
