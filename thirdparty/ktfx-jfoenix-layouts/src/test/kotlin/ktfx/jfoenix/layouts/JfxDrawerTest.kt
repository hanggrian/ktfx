package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXDrawer
import javafx.scene.layout.Region
import ktfx.layouts.KtfxPane
import ktfx.layouts.region
import kotlin.test.Test
import kotlin.test.assertIs

class JfxDrawerTest : LayoutsStyledTest<KtfxPane, JFXDrawer>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxDrawer {}

    override fun KtfxPane.child2() = jfxDrawer()

    override fun child3() = styledJfxDrawer()

    override fun KtfxPane.child4() = styledJfxDrawer()

    @Test
    fun add() {
        jfxDrawer {
            region()
            assertIs<Region>(children.first())
        }
    }
}
