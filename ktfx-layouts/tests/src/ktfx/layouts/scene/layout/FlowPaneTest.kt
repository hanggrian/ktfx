package ktfx.layouts.scene.layout

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.flowPane
import ktfx.layouts.region
import ktfx.testing.LayoutToolkitTest
import kotlin.test.assertEquals

class FlowPaneTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        flowPane {
            val region1 = region { constraints marginAll 0.0 }
            assertEquals(0.0, region1.constraints.marginTop)
            assertEquals(0.0, region1.constraints.marginLeft)
            assertEquals(0.0, region1.constraints.marginBottom)
            assertEquals(0.0, region1.constraints.marginRight)
            val region2 = region { constraints marginTop 10.0 marginLeft 20.0 marginBottom 30.0 marginRight 40.0 }
            assertEquals(10.0, region2.constraints.marginTop)
            assertEquals(20.0, region2.constraints.marginLeft)
            assertEquals(30.0, region2.constraints.marginBottom)
            assertEquals(40.0, region2.constraints.marginRight)

            region1.constraints.clear()
            assertEquals(region1.constraints.margin, null)
            region2.constraints.clear()
            assertEquals(region2.constraints.margin, null)

            assertEquals(children.size, 2)
        }
    }
}