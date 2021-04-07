package ktfx.layouts

import javafx.scene.control.Separator
import com.hendraanggrian.ktfx.test.LayoutsTest

class SeparatorTest : LayoutsTest<KtfxPane, Separator>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = separator { }
    override fun KtfxPane.child2() = separator()
    override fun KtfxPane.child3() = separator { }
}