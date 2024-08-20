package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.concurrent.Task
import ktfx.layouts.KtfxPane
import org.controlsfx.control.TaskProgressView

class TaskProgressViewTest : LayoutsStyledTest<KtfxPane, TaskProgressView<Task<String>>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = taskProgressView<Task<String>> {}

    override fun KtfxPane.child2() = taskProgressView<Task<String>>()

    override fun child3() = styledTaskProgressView<Task<String>>()

    override fun KtfxPane.child4() = styledTaskProgressView<Task<String>>()
}
