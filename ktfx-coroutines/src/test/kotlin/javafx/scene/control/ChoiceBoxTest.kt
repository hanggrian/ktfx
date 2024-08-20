package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ChoiceBox
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ChoiceBoxTest : ApplicationTest() {
    private lateinit var choice: ChoiceBox<String>

    override fun start(stage: Stage) {
        stage.testScene<ChoiceBox<*>>()
        choice = ChoiceBox()
    }

    @Test
    fun onAction() {
        interact {
            choice.onAction {
                assertEquals(this@ChoiceBoxTest, it.source)
                assertEquals(FakeEventTarget, it.target)
            }
            choice.onAction.handle(ActionEvent(this, FakeEventTarget))
        }
    }

    @Test
    fun onShowing() {
        interact {
            choice.onShowing {
                assertEquals(this@ChoiceBoxTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            choice.onShowing.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onShown() {
        interact {
            choice.onShown {
                assertEquals(this@ChoiceBoxTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            choice.onShown.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onHiding() {
        interact {
            choice.onHiding {
                assertEquals(this@ChoiceBoxTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            choice.onHiding.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onHidden() {
        interact {
            choice.onHidden {
                assertEquals(this@ChoiceBoxTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            choice.onHidden.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }
}
