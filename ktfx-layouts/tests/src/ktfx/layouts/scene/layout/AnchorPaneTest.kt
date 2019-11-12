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
            val region1 = region {
                anchorAll = 0.0
            }
            assertEquals(0.0, region1.anchorTop)
            assertEquals(0.0, region1.anchorLeft)
            assertEquals(0.0, region1.anchorBottom)
            assertEquals(0.0, region1.anchorRight)
            val region2 = region {
                anchorTop = 10.0
                anchorLeft = 20.0
                anchorBottom = 30.0
                anchorRight = 40.0
            }
            assertEquals(10.0, region2.anchorTop)
            assertEquals(20.0, region2.anchorLeft)
            assertEquals(30.0, region2.anchorBottom)
            assertEquals(40.0, region2.anchorRight)

            region1.removeConstraints()
            assertEquals(region1.anchorTop, null)
            assertEquals(region1.anchorLeft, null)
            assertEquals(region1.anchorBottom, null)
            assertEquals(region1.anchorRight, null)
            region2.removeConstraints()
            assertEquals(region2.anchorTop, null)
            assertEquals(region2.anchorLeft, null)
            assertEquals(region2.anchorBottom, null)
            assertEquals(region2.anchorRight, null)

            assertEquals(children.size, 2)
        }
    }
}