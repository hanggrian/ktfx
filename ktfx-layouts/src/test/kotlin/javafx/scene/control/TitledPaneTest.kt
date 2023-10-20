package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.TitledPane
import kotlin.test.assertNull

class TitledPaneTest : LayoutsTest<KtfxAccordion, TitledPane>() {
    override fun manager(): KtfxAccordion = KtfxAccordion()

    override fun KtfxAccordion.childCount(): Int = panes.size

    override fun child1(): TitledPane = titledPane { }

    override fun KtfxAccordion.child2(): TitledPane = titledPane()

    override fun KtfxAccordion.child3(): TitledPane = titledPane { }

    override fun TitledPane.testDefaultValues() {
        assertNull(text)
    }
}
