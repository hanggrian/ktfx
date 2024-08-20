package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.Region

class RegionTest : LayoutsStyledTest<KtfxPane, Region>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = region {}

    override fun KtfxPane.child2() = region()

    override fun child3() = styledRegion()

    override fun KtfxPane.child4() = styledRegion()
}
