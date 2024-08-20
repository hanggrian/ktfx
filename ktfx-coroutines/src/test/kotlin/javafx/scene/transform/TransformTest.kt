package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.scene.transform.Scale
import javafx.scene.transform.Transform
import javafx.scene.transform.TransformChangedEvent
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TransformTest : ApplicationTest() {
    override fun start(stage: Stage) {
        stage.testScene<Transform>()
    }

    @Test
    fun onAction() {
        interact {
            val transform = Scale()
            transform.onTransformChanged {
                assertEquals(this@TransformTest, it.source)
                assertEquals(FakeEventTarget, it.target)
            }
            transform.onTransformChanged.handle(TransformChangedEvent(this, FakeEventTarget))
        }
    }
}
