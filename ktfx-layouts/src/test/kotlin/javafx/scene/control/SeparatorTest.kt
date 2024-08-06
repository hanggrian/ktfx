package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.Separator

class SeparatorTest : LayoutsTest<KtfxPane, Separator>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Separator = separator { }

    override fun KtfxPane.child2(): Separator = separator()

    override fun KtfxPane.child3(): Separator = separator { }
}
