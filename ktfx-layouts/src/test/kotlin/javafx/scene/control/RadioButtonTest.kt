package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.RadioButton
import kotlin.test.assertNull

class RadioButtonTest : LayoutsTest<KtfxPane, RadioButton>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): RadioButton = radioButton { }

    override fun KtfxPane.child2(): RadioButton = radioButton()

    override fun KtfxPane.child3(): RadioButton = radioButton { }

    override fun RadioButton.testDefaultValues() {
        assertNull(text)
    }
}
