package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.beans.Observable
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableTest : ApplicationTest() {
    override fun start(stage: Stage) {
        stage.testScene<Observable>()
    }

    @Test
    fun listener() {
        interact {
            val property = SimpleStringProperty()
            property.listener {
                assertTrue(it is StringProperty)
                assertEquals("Hello world", it.get())
            }
            property.set("Hello world")
        }
    }
}
