package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.beans.value.ObservableValue
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ObservableValueTest : ApplicationTest() {
    override fun start(stage: Stage) {
        stage.testScene<ObservableValue<*>>()
    }

    @Test
    fun listener() {
        interact {
            val property = SimpleStringProperty()
            property.listener { observable, oldValue, value ->
                assertTrue(observable is StringProperty)
                assertNull(oldValue)
                assertEquals("Hello world", value)
            }
            property.set("Hello world")
        }
    }
}
