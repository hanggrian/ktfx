package ktfx.layouts

import javafx.scene.shape.SVGPath
import ktfx.test.BaseLayoutTest

class SVGPathTest : BaseLayoutTest<NodeManager, SVGPath>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = svgPath { }
    override fun NodeManager.child2() = svgPath()
    override fun NodeManager.child3() = svgPath { }
}