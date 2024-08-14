package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.AnchorPane
import kotlin.test.Test
import kotlin.test.assertEquals

class AnchorPaneTest : LayoutsStyledTest<KtfxPane, AnchorPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = anchorPane {}

    override fun KtfxPane.child2() = anchorPane()

    override fun child3() = styledAnchorPane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledAnchorPane(styleClass = arrayOf("style"))

    @Test
    fun anchors() {
        anchorPane {
            val region1 = region().anchor(5)
            assertEquals(5.0, region1.topAnchor)
            assertEquals(5.0, region1.leftAnchor)
            assertEquals(5.0, region1.bottomAnchor)
            assertEquals(5.0, region1.rightAnchor)
            val region2 = region().anchor(top = 10, left = 20, bottom = 30, right = 40)
            assertEquals(10.0, region2.topAnchor)
            assertEquals(20.0, region2.leftAnchor)
            assertEquals(30.0, region2.bottomAnchor)
            assertEquals(40.0, region2.rightAnchor)
            val region3 = region().anchor(vertical = 10, horizontal = 20)
            assertEquals(10.0, region3.topAnchor)
            assertEquals(20.0, region3.leftAnchor)
            assertEquals(10.0, region3.bottomAnchor)
            assertEquals(20.0, region3.rightAnchor)

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

            region3.clearConstraints()
            assertEquals(region3.topAnchor, null)
            assertEquals(region3.leftAnchor, null)
            assertEquals(region3.bottomAnchor, null)
            assertEquals(region3.rightAnchor, null)

            assertEquals(children.size, 3)
        }
    }
}
