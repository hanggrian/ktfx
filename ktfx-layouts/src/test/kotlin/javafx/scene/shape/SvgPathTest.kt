package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.SVGPath

class SvgPathTest : LayoutsStyledTest<KtfxPane, SVGPath>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = svgPath {}

    override fun KtfxPane.child2() = svgPath()

    override fun child3() = styledSvgPath(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledSvgPath(styleClass = arrayOf("style"))
}
