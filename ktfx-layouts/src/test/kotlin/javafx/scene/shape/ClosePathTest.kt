package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.ClosePath

class ClosePathTest : LayoutsTest<KtfxPath, ClosePath>() {
    override fun manager(): KtfxPath = KtfxPath()
    override fun KtfxPath.childCount(): Int = elements.size
    override fun child1(): ClosePath = closePath { }
    override fun KtfxPath.child2(): ClosePath = closePath()
    override fun KtfxPath.child3(): ClosePath = closePath { }
}
