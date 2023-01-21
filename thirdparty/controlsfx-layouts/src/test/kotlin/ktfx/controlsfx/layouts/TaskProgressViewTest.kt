package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.concurrent.Task
import ktfx.layouts.KtfxPane
import org.controlsfx.control.TaskProgressView

class TaskProgressViewTest : LayoutsTest<KtfxPane, TaskProgressView<Task<String>>>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): TaskProgressView<Task<String>> = taskProgressView { }
    override fun KtfxPane.child2(): TaskProgressView<Task<String>> = taskProgressView()
    override fun KtfxPane.child3(): TaskProgressView<Task<String>> = taskProgressView { }
}
