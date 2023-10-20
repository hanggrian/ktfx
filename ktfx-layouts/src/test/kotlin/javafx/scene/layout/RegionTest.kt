package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.layout.Region

class RegionTest : LayoutsTest<KtfxPane, Region>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Region = region { }

    override fun KtfxPane.child2(): Region = region()

    override fun KtfxPane.child3(): Region = region { }
}
