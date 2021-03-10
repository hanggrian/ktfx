package ktfx.layouts

import javafx.scene.shape.ClosePath
import io.github.hendraanggrian.ktfx.test.LayoutsTest

class ClosePathTest : LayoutsTest<KtfxPath, ClosePath>() {

    override fun manager() = KtfxPath()
    override fun KtfxPath.childCount() = elements.size
    override fun child1() = closePath { }
    override fun KtfxPath.child2() = closePath()
    override fun KtfxPath.child3() = closePath { }
}