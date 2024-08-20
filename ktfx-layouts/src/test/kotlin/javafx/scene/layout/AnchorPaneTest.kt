package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.AnchorPane
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class AnchorPaneTest : LayoutsStyledTest<KtfxPane, AnchorPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = anchorPane {}

    override fun KtfxPane.child2() = anchorPane()

    override fun child3() = styledAnchorPane()

    override fun KtfxPane.child4() = styledAnchorPane()

    @Test
    fun anchor() {
        anchorPane {
            val region = region()

            region.anchor(1)
            assertEquals(1.0, region.topAnchor)
            assertEquals(1.0, region.leftAnchor)
            assertEquals(1.0, region.bottomAnchor)
            assertEquals(1.0, region.rightAnchor)
            region.clearConstraints()

            region.anchor(2L)
            assertEquals(2.0, region.topAnchor)
            assertEquals(2.0, region.leftAnchor)
            assertEquals(2.0, region.bottomAnchor)
            assertEquals(2.0, region.rightAnchor)
            region.clearConstraints()

            region.anchor(3.0)
            assertEquals(3.0, region.topAnchor)
            assertEquals(3.0, region.leftAnchor)
            assertEquals(3.0, region.bottomAnchor)
            assertEquals(3.0, region.rightAnchor)
            region.clearConstraints()

            region.anchor(vertical = 4)
            assertEquals(4.0, region.topAnchor)
            assertEquals(4.0, region.bottomAnchor)
            region.anchor(horizontal = 5)
            assertEquals(5.0, region.leftAnchor)
            assertEquals(5.0, region.rightAnchor)
            region.clearConstraints()

            region.anchor(vertical = 6L)
            assertEquals(6.0, region.topAnchor)
            assertEquals(6.0, region.bottomAnchor)
            region.anchor(horizontal = 7L)
            assertEquals(7.0, region.leftAnchor)
            assertEquals(7.0, region.rightAnchor)
            region.clearConstraints()

            region.anchor(vertical = 8.0)
            assertEquals(8.0, region.topAnchor)
            assertEquals(8.0, region.bottomAnchor)
            region.anchor(horizontal = 9.0)
            assertEquals(9.0, region.leftAnchor)
            assertEquals(9.0, region.rightAnchor)
            region.clearConstraints()

            region.anchor(top = 10)
            assertEquals(10.0, region.topAnchor)
            region.anchor(right = 11)
            assertEquals(11.0, region.rightAnchor)
            region.anchor(bottom = 12)
            assertEquals(12.0, region.bottomAnchor)
            region.anchor(left = 13)
            assertEquals(13.0, region.leftAnchor)
            region.clearConstraints()

            region.anchor(top = 14L)
            assertEquals(14.0, region.topAnchor)
            region.anchor(right = 15L)
            assertEquals(15.0, region.rightAnchor)
            region.anchor(bottom = 16L)
            assertEquals(16.0, region.bottomAnchor)
            region.anchor(left = 17L)
            assertEquals(17.0, region.leftAnchor)
            region.clearConstraints()

            region.anchor(top = 18.0)
            assertEquals(18.0, region.topAnchor)
            region.anchor(right = 19.0)
            assertEquals(19.0, region.rightAnchor)
            region.anchor(bottom = 20.0)
            assertEquals(20.0, region.bottomAnchor)
            region.anchor(left = 21.0)
            assertEquals(21.0, region.leftAnchor)
            region.clearConstraints()

            region.topAnchor = 22.0
            assertEquals(22.0, region.topAnchor)
            region.rightAnchor = 23.0
            assertEquals(23.0, region.rightAnchor)
            region.bottomAnchor = 24.0
            assertEquals(24.0, region.bottomAnchor)
            region.leftAnchor = 25.0
            assertEquals(25.0, region.leftAnchor)
            region.clearConstraints()

            assertNull(region.topAnchor)
            assertNull(region.leftAnchor)
            assertNull(region.bottomAnchor)
            assertNull(region.rightAnchor)
        }
    }
}
