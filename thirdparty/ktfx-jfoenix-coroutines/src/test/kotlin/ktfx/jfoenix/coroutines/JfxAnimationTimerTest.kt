package ktfx.jfoenix.coroutines

import com.hanggrian.ktfx.test.testScene
import com.jfoenix.transitions.JFXAnimationTimer
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertTrue

class JfxAnimationTimerTest : ApplicationTest() {
    private lateinit var timer: JFXAnimationTimer

    override fun start(stage: Stage) {
        stage.testScene<JFXAnimationTimer>()
        timer = JFXAnimationTimer()
    }

    @Test
    fun onFinished() {
        var assigned = false
        interact {
            timer.onFinished {
                assigned = true
            }
            timer.start()
        }
        assertTrue(assigned)
    }
}
