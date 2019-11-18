package ktfx.layouts.scene.layout

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.anchorPane
import ktfx.layouts.region
import ktfx.testing.LayoutToolkitTest
import kotlin.test.assertEquals

class AnchorPaneTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        anchorPane {
            val region1 = region { constraints anchorAll 0.0 }
            assertEquals(0.0, region1.constraints.anchorTop)
            assertEquals(0.0, region1.constraints.anchorLeft)
            assertEquals(0.0, region1.constraints.anchorBottom)
            assertEquals(0.0, region1.constraints.anchorRight)
            val region2 = region { constraints anchorTop 10.0 anchorLeft 20.0 anchorBottom 30.0 anchorRight 40.0 }
            assertEquals(10.0, region2.constraints.anchorTop)
            assertEquals(20.0, region2.constraints.anchorLeft)
            assertEquals(30.0, region2.constraints.anchorBottom)
            assertEquals(40.0, region2.constraints.anchorRight)

            region1.constraints.clear()
            assertEquals(region1.constraints.anchorTop, null)
            assertEquals(region1.constraints.anchorLeft, null)
            assertEquals(region1.constraints.anchorBottom, null)
            assertEquals(region1.constraints.anchorRight, null)
            region2.constraints.clear()
            assertEquals(region2.constraints.anchorTop, null)
            assertEquals(region2.constraints.anchorLeft, null)
            assertEquals(region2.constraints.anchorBottom, null)
            assertEquals(region2.constraints.anchorRight, null)

            assertEquals(children.size, 2)
        }
    }
}