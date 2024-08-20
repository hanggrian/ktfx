package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXNodesList
import javafx.scene.layout.Region
import ktfx.layouts.KtfxPane
import ktfx.layouts.region
import kotlin.test.Test
import kotlin.test.assertIs

class JfxNodesListTest : LayoutsStyledTest<KtfxPane, JFXNodesList>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxNodesList {}

    override fun KtfxPane.child2() = jfxNodesList()

    override fun child3() = styledJfxNodesList()

    override fun KtfxPane.child4() = styledJfxNodesList()

    @Test
    fun add() {
        jfxNodesList {
            region()
            assertIs<Region>(children.single())
        }
    }
}
