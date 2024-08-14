package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.Path

class PathTest : LayoutsStyledTest<KtfxPane, Path>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = path {}

    override fun KtfxPane.child2() = path()

    override fun child3() = styledPath(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledPath(styleClass = arrayOf("style"))
}
