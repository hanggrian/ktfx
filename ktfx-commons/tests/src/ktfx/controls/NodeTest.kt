package ktfx.controls

import javafx.scene.Scene
import javafx.scene.control.TabPane
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import ktfx.test.AppTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
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