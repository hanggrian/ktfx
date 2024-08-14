package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.ClosePath

class ClosePathTest : LayoutsTest<KtfxPath, ClosePath>() {
    override fun manager() = KtfxPath()

    override fun KtfxPath.childCount() = elements.size

    override fun child1() = closePath {}

    override fun KtfxPath.child2() = closePath()
}
