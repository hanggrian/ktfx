package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableListTest : ApplicationTest() {
    override fun start(stage: Stage) {
        stage.testScene<ObservableList<*>>()
    }

    @Test
    fun listener() {
        interact {
            val collection = FXCollections.observableArrayList<String>()
            collection.listener<String> {
                it.next()
                assertEquals(0, it.from)
                assertEquals(1, it.to)
                assertTrue(it.wasAdded())
                assertEquals("Hello world", it.addedSubList.single())
            }
            collection.add("Hello world")
        }
    }
}
