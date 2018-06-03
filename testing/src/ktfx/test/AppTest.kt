package ktfx.test

import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest

abstract class AppTest : ApplicationTest() {

    abstract override fun start(stage: Stage)
}