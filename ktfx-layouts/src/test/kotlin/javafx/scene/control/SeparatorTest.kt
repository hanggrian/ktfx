package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.Separator

class SeparatorTest : LayoutsStyledTest<KtfxPane, Separator>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = separator {}

    override fun KtfxPane.child2() = separator()

    override fun child3() = styledSeparator()

    override fun KtfxPane.child4() = styledSeparator()
}
