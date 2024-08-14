package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.CheckBox
import kotlin.test.assertNull

class CheckBoxTest : LayoutsStyledTest<KtfxPane, CheckBox>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = checkBox {}

    override fun KtfxPane.child2() = checkBox()

    override fun child3(): CheckBox = styledCheckBox(styleClass = arrayOf("style"))

    override fun KtfxPane.child4(): CheckBox = styledCheckBox(styleClass = arrayOf("style"))

    override fun CheckBox.testDefaultValues() {
        assertNull(text)
    }
}
