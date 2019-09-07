package ktfx.layouts.scene.layout

import ktfx.layouts.NodeManager
import ktfx.layouts._Pane
import ktfx.layouts.anchorPane
import ktfx.layouts.region
import ktfx.test.LayoutToolkitTest
import kotlin.test.assertEquals

class AnchorPaneTest : LayoutToolkitTest<NodeManager>(_Pane()) {

    override fun NodeManager.layout() {
        anchorPane {
            val region1 = region() anchorAll 10.0
            assertEquals(10.0, region1.anchorTop)
            assertEquals(10.0, region1.anchorLeft)
            assertEquals(10.0, region1.anchorBottom)
            assertEquals(10.0, region1.anchorRight)
            val region2 = region() anchorTop 10.0
            assertEquals(10.0, region2.anchorTop)
            val region3 = region() anchorLeft 10.0
            assertEquals(10.0, region3.anchorLeft)
            val region4 = region() anchorBottom 10.0
            assertEquals(10.0, region4.anchorBottom)
            val region5 = region() anchorRight 10.0
            assertEquals(10.0, region5.anchorRight)

            region1.reset()
            assertEquals(region1.anchorTop, null)
            assertEquals(region1.anchorLeft, null)
            assertEquals(region1.anchorBottom, null)
            assertEquals(region1.anchorRight, null)
            region2.reset()
            assertEquals(region2.anchorTop, null)
            region3.reset()
            assertEquals(region3.anchorLeft, null)
            region4.reset()
            assertEquals(region4.anchorBottom, null)
            region5.reset()
            assertEquals(region5.anchorRight, null)

            assertEquals(children.size, 5)
        }
    }
}