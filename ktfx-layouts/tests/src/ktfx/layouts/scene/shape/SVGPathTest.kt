package ktfx.layouts.scene.shape

import javafx.scene.shape.SVGPath
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.svgPath
import ktfx.test.LayoutTest

class SVGPathTest : LayoutTest<NodeManager, SVGPath>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = svgPath { }
    override fun NodeManager.child2() = svgPath()
    override fun NodeManager.child3() = svgPath { }
}