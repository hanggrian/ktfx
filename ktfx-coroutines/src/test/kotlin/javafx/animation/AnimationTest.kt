package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.animation.Animation
import javafx.animation.ScaleTransition
import javafx.event.ActionEvent
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class AnimationTest : ApplicationTest() {
    override fun start(stage: Stage) {
        stage.testScene<Animation>()
    }

    @Test
    fun onFinished() {
        interact {
            val scale = ScaleTransition()
            scale.onFinished {
                assertEquals(this@AnimationTest, it.source)
                assertEquals(FakeEventTarget, it.target)
            }
            scale.onFinished.handle(ActionEvent(this, FakeEventTarget))
        }
    }
}
