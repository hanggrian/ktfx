package ktfx.layouts

import javafx.scene.shape.SVGPath
import com.hendraanggrian.ktfx.test.LayoutsTest

class SVGPathTest : LayoutsTest<KtfxPane, SVGPath>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = svgPath { }
    override fun KtfxPane.child2() = svgPath()
    override fun KtfxPane.child3() = svgPath { }
}