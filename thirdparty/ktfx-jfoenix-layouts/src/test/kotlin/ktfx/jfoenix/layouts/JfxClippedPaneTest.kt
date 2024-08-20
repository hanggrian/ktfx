package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXClippedPane
import javafx.scene.layout.Region
import ktfx.layouts.KtfxPane
import ktfx.layouts.region
import kotlin.test.Test
import kotlin.test.assertIs

class JfxClippedPaneTest : LayoutsStyledTest<KtfxPane, JFXClippedPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxClippedPane {}

    override fun KtfxPane.child2() = jfxClippedPane()

    override fun child3() = styledJfxClippedPane()

    override fun KtfxPane.child4() = styledJfxClippedPane()

    @Test
    fun add() {
        jfxClippedPane {
            region()
            assertIs<Region>(children.single())
        }
    }
}
