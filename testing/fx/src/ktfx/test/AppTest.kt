package ktfx.test

import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest

/** Full-fledge JavaFX app test by TestFX. */
abstract class AppTest : ApplicationTest() {

    abstract override fun start(stage: Stage)
}