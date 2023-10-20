package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.CheckBox
import kotlin.test.assertNull

class CheckBoxTest : LayoutsTest<KtfxPane, CheckBox>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): CheckBox = checkBox { }

    override fun KtfxPane.child2(): CheckBox = checkBox()

    override fun KtfxPane.child3(): CheckBox = checkBox { }

    override fun CheckBox.testDefaultValues() {
        assertNull(text)
    }
}
