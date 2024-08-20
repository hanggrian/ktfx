package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.Line

class LineTest : LayoutsStyledTest<KtfxPane, Line>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = line {}

    override fun KtfxPane.child2() = line()

    override fun child3() = styledLine()

    override fun KtfxPane.child4() = styledLine()
}
