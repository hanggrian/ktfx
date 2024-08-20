package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ComboBox
import javafx.scene.control.ComboBoxBase
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ComboBoxBaseTest : ApplicationTest() {
    private lateinit var combo: ComboBoxBase<String>

    override fun start(stage: Stage) {
        stage.testScene<ComboBoxBase<*>>()
        combo = ComboBox()
    }

    @Test
    fun onAction() {
        interact {
            combo.onAction {
                assertEquals(this@ComboBoxBaseTest, it.source)
                assertEquals(FakeEventTarget, it.target)
            }
            combo.onAction.handle(ActionEvent(this, FakeEventTarget))
        }
    }

    @Test
    fun onShowing() {
        interact {
            combo.onShowing {
                assertEquals(this@ComboBoxBaseTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            combo.onShowing.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onShown() {
        interact {
            combo.onShown {
                assertEquals(this@ComboBoxBaseTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            combo.onShown.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onHiding() {
        interact {
            combo.onHiding {
                assertEquals(this@ComboBoxBaseTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            combo.onHiding.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onHidden() {
        interact {
            combo.onHidden {
                assertEquals(this@ComboBoxBaseTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            combo.onHidden.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }
}
