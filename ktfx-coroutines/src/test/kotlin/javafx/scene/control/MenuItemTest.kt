package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.MenuItem
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MenuItemTest : ApplicationTest() {
    private lateinit var item: MenuItem

    override fun start(stage: Stage) {
        stage.testScene<MenuItem>()
        item = MenuItem()
    }

    @Test
    fun onAction() {
        interact {
            item.onAction {
                assertEquals(this@MenuItemTest, it.source)
                assertEquals(FakeEventTarget, it.target)
            }
            item.onAction.handle(ActionEvent(this, FakeEventTarget))
        }
    }

    @Test
    fun onMenuValidation() {
        interact {
            item.onMenuValidation {
                assertEquals(this@MenuItemTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            item.onMenuValidation.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }
}
