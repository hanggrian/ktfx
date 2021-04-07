package ktfx.layouts

import javafx.scene.shape.Path
import com.hendraanggrian.ktfx.test.LayoutsTest

class PathTest : LayoutsTest<KtfxPane, Path>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = path { }
    override fun KtfxPane.child2() = path()
    override fun KtfxPane.child3() = path { }
}