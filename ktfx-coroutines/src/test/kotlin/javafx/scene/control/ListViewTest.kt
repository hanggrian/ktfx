package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ListViewTest : ApplicationTest() {
    private lateinit var control: ListView<String>

    override fun start(stage: Stage) {
        stage.testScene<ListView<*>>()
        control = ListView()
    }

    @Test
    fun onEditStart() {
        interact {
            control.onEditStart {
                assertEquals(control, it.source)
                assertEquals(ListView.editStartEvent<String>(), it.eventType)
                assertEquals("", it.newValue)
                assertEquals(0, it.index)
            }
            control.onEditStart.handle(
                ListView.EditEvent(
                    control,
                    ListView.editStartEvent(),
                    "",
                    0,
                ),
            )
        }
    }

    @Test
    fun onEditCommit() {
        interact {
            control.onEditCommit {
                assertEquals(control, it.source)
                assertEquals(ListView.editCommitEvent<String>(), it.eventType)
                assertEquals("", it.newValue)
                assertEquals(0, it.index)
            }
            control.onEditCommit.handle(
                ListView.EditEvent(
                    control,
                    ListView.editCommitEvent(),
                    "",
                    0,
                ),
            )
        }
    }

    @Test
    fun onEditCancel() {
        interact {
            control.onEditCancel {
                assertEquals(control, it.source)
                assertEquals(ListView.editCancelEvent<String>(), it.eventType)
                assertEquals("", it.newValue)
                assertEquals(0, it.index)
            }
            control.onEditCancel.handle(
                ListView.EditEvent(
                    control,
                    ListView.editCancelEvent(),
                    "",
                    0,
                ),
            )
        }
    }

    @Test
    fun onScrollTo() {
        interact {
            control.onScrollTo {
                assertEquals(this@ListViewTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(ScrollToEvent.scrollToTopIndex(), it.eventType)
                assertEquals(0, it.scrollTarget)
            }
            control.onScrollTo
                .handle(ScrollToEvent(this, FakeEventTarget, ScrollToEvent.scrollToTopIndex(), 0))
        }
    }
}
