package ktfx.layouts.scene.shape

import javafx.scene.shape.SVGPath
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.svgPath

class SVGPathTest : LayoutTest<NodeManager, SVGPath>() {

    override fun createManager() = KtfxPane()
    override fun create() = svgPath { }
    override fun NodeManager.add() = svgPath()
    override fun NodeManager.addWithBuilder() = svgPath { }
}