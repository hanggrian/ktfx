package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXMasonryPane
import javafx.scene.layout.Region
import ktfx.layouts.KtfxPane
import ktfx.layouts.region
import kotlin.test.Test
import kotlin.test.assertIs

class JfxMasonryPaneTest : LayoutsStyledTest<KtfxPane, JFXMasonryPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxMasonryPane {}

    override fun KtfxPane.child2() = jfxMasonryPane()

    override fun child3() = styledJfxMasonryPane()

    override fun KtfxPane.child4() = styledJfxMasonryPane()

    @Test
    fun add() {
        jfxMasonryPane {
            region()
            assertIs<Region>(children.single())
        }
    }
}
