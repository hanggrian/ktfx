package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.layout.Pane

class PaneTest : LayoutsTest<KtfxPane, Pane>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Pane = pane { }

    override fun KtfxPane.child2(): Pane = pane()

    override fun KtfxPane.child3(): Pane = pane { }
}
