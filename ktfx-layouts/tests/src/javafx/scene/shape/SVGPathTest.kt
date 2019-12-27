package ktfx.layouts

import javafx.scene.shape.SVGPath
import ktfx.test.LayoutsTest

class SVGPathTest : LayoutsTest<NodeManager, SVGPath>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = svgPath { }
    override fun NodeManager.child2() = svgPath()
    override fun NodeManager.child3() = svgPath { }
}