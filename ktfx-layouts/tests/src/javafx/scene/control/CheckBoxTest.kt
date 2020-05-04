package ktfx.layouts

import javafx.scene.control.CheckBox
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class CheckBoxTest : LayoutsTest<KtfxPane, CheckBox>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = checkBox { }
    override fun KtfxPane.child2() = checkBox()
    override fun KtfxPane.child3() = checkBox { }

    override fun CheckBox.testDefaultValues() {
        assertNull(text)
    }
}