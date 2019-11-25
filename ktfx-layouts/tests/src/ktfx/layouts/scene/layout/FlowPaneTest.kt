package ktfx.layouts.scene.layout

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.flowPane
import ktfx.layouts.region
import ktfx.test.LayoutToolkitTest
import kotlin.test.assertEquals

class FlowPaneTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        flowPane {
            val region1 = region() marginAll 0.0
            assertEquals(0.0, region1.margin?.top)
            assertEquals(0.0, region1.margin?.left)
            assertEquals(0.0, region1.margin?.bottom)
            assertEquals(0.0, region1.margin?.right)
            val region2 = region() marginTop 10.0 marginLeft 20.0 marginBottom 30.0 marginRight 40.0
            assertEquals(10.0, region2.margin?.top)
            assertEquals(20.0, region2.margin?.left)
            assertEquals(30.0, region2.margin?.bottom)
            assertEquals(40.0, region2.margin?.right)

            region1.clearConstraints()
            assertEquals(region1.margin, null)
            region2.clearConstraints()
            assertEquals(region2.margin, null)

            assertEquals(children.size, 2)
        }
    }
}