package ktfx.layouts

import javafx.scene.layout.Region
import io.github.hendraanggrian.ktfx.test.LayoutsTest

class RegionTest : LayoutsTest<KtfxPane, Region>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = region { }
    override fun KtfxPane.child2() = region()
    override fun KtfxPane.child3() = region { }
}