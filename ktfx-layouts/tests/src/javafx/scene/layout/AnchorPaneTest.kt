package ktfx.layouts

import javafx.scene.layout.AnchorPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.Test
import kotlin.test.assertEquals

class AnchorPaneTest : LayoutsTest<KtfxPane, AnchorPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = anchorPane { }
    override fun KtfxPane.child2() = anchorPane()
    override fun KtfxPane.child3() = anchorPane { }

    @Test fun anchors() {
        anchorPane {
            val region1 = region() anchors 0.0
            assertEquals(0.0, region1.topAnchor)
            assertEquals(0.0, region1.leftAnchor)
            assertEquals(0.0, region1.bottomAnchor)
            assertEquals(0.0, region1.rightAnchor)
            val region2 = region() topAnchor 10.0 leftAnchor 20.0 bottomAnchor 30.0 rightAnchor 40.0
            assertEquals(10.0, region2.topAnchor)
            assertEquals(20.0, region2.leftAnchor)
            assertEquals(30.0, region2.bottomAnchor)
            assertEquals(40.0, region2.rightAnchor)

            region1.clearConstraints()
            assertEquals(region1.topAnchor, null)
            assertEquals(region1.leftAnchor, null)
            assertEquals(region1.bottomAnchor, null)
            assertEquals(region1.rightAnchor, null)
            region2.clearConstraints()
            assertEquals(region2.topAnchor, null)
            assertEquals(region2.leftAnchor, null)
            assertEquals(region2.bottomAnchor, null)
            assertEquals(region2.rightAnchor, null)

            assertEquals(children.size, 2)
        }
    }
}