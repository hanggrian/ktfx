package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXTogglePane
import javafx.scene.layout.Region
import ktfx.layouts.KtfxPane
import ktfx.layouts.region
import kotlin.test.Test
import kotlin.test.assertIs

class JfxTogglePaneTest : LayoutsStyledTest<KtfxPane, JFXTogglePane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxTogglePane {}

    override fun KtfxPane.child2() = jfxTogglePane()

    override fun child3() = styledJfxTogglePane()

    override fun KtfxPane.child4() = styledJfxTogglePane()

    @Test
    fun add() {
        jfxTogglePane {
            region()
            assertIs<Region>(contentNode)
        }
    }
}
