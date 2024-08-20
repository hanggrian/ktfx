package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.collections.FXCollections
import javafx.collections.ObservableMap
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableMapTest : ApplicationTest() {
    override fun start(stage: Stage) {
        stage.testScene<ObservableMap<*, *>>()
    }

    @Test
    fun listener() {
        interact {
            val collection = FXCollections.observableHashMap<Int, String>()
            collection.listener<Int, String> {
                assertTrue(it.wasAdded())
                assertEquals(1, it.key)
                assertEquals("Hello world", it.valueAdded)
            }
            collection[1] = "Hello world"
        }
    }
}
