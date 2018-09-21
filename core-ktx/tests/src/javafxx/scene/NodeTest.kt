package javafxx.scene

import javafx.scene.Scene
import javafx.scene.control.TabPane
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import javafxx.test.AppTest
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import org.junit.Test
import kotlin.test.assertNotNull

class NodeTest : AppTest() {

    lateinit var tabPane: TabPane

    override fun start(stage: Stage) {
        tabPane = TabPane()
        stage.scene = Scene(tabPane)
    }

    @Test fun lookup() {
        GlobalScope.launch(Dispatchers.JavaFx) {
            delay(200)
            assertNotNull(tabPane.find<StackPane>(".tab-content-area"))
        }
    }
}