package ktfx.testing

import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest

/**
 * Few tests requires a full-blown JavaFX app to run like window creation,
 * mouse/keyboard event, etc. It is made possible with [TestFX].
 */
abstract class AppTest : ApplicationTest() {

    abstract override fun start(stage: Stage)
}
