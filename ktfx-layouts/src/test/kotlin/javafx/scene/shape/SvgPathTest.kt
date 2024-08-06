package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.SVGPath

class SvgPathTest : LayoutsTest<KtfxPane, SVGPath>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): SVGPath = svgPath { }

    override fun KtfxPane.child2(): SVGPath = svgPath()

    override fun KtfxPane.child3(): SVGPath = svgPath { }
}
