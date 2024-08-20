package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.collections.FXCollections
import javafx.collections.ObservableSet
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableSetTest : ApplicationTest() {
    override fun start(stage: Stage) {
        stage.testScene<ObservableSet<*>>()
    }

    @Test
    fun listener() {
        interact {
            val collection = FXCollections.observableSet<String>()
            collection.listener<String> {
                assertTrue(it.wasAdded())
                assertEquals("Hello world", it.elementAdded)
            }
            collection.add("Hello world")
        }
    }
}
