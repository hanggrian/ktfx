package ktfx.controlsfx.layouts

import javafx.concurrent.Task
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import org.controlsfx.control.TaskProgressView

class TaskProgressViewTest : LayoutsTest<NodeManager, TaskProgressView<Task<String>>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = taskProgressView<Task<String>> { }
    override fun NodeManager.child2() = taskProgressView<Task<String>>()
    override fun NodeManager.child3() = taskProgressView<Task<String>> { }
}