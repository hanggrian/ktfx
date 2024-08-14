package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXDecorator
import javafx.scene.control.Label
import javafx.stage.Stage
import ktfx.layouts.KtfxPane
import kotlin.test.Ignore

// requires active window
@Ignore
class JfxDecoratorTest : LayoutsStyledTest<KtfxPane, JFXDecorator>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxDecorator(manager.scene.window as Stage, Label()) {}

    override fun KtfxPane.child2() = jfxDecorator(manager.scene.window as Stage, Label())

    override fun child3() =
        styledJfxDecorator(manager.scene.window as Stage, Label(), styleClass = arrayOf("style"))

    override fun KtfxPane.child4() =
        styledJfxDecorator(manager.scene.window as Stage, Label(), styleClass = arrayOf("style"))
}
