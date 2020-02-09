package ktfx.controlsfx.layouts

import javafx.concurrent.Task
import ktfx.layouts.KtfxPane
import ktfx.test.LayoutsTest
import org.controlsfx.control.TaskProgressView

class TaskProgressViewTest : LayoutsTest<KtfxPane, TaskProgressView<Task<String>>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = taskProgressView<Task<String>> { }
    override fun KtfxPane.child2() = taskProgressView<Task<String>>()
    override fun KtfxPane.child3() = taskProgressView<Task<String>> { }
}