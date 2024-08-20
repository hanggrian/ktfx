package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.collections.FXCollections
import javafx.collections.ObservableArray
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableArrayTest : ApplicationTest() {
    override fun start(stage: Stage) {
        stage.testScene<ObservableArray<*>>()
    }

    @Test
    fun listener() {
        interact {
            val array = FXCollections.observableIntegerArray()
            array.listener { observable, changed, from, to ->
                assertEquals(observable, array)
                assertTrue(changed)
                assertEquals(0, from)
                assertEquals(1, to)
            }
            array.addAll(1)
        }
    }
}
