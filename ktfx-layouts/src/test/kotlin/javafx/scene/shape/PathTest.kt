package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.Path

class PathTest : LayoutsTest<KtfxPane, Path>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Path = path { }

    override fun KtfxPane.child2(): Path = path()

    override fun KtfxPane.child3(): Path = path { }
}
