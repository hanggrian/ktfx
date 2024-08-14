package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.InfoOverlay
import kotlin.test.assertNull

class InfoOverlayTest : LayoutsStyledTest<KtfxPane, InfoOverlay>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = infoOverlay {}

    override fun KtfxPane.child2() = infoOverlay()

    override fun child3() = styledInfoOverlay(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledInfoOverlay(styleClass = arrayOf("style"))

    override fun InfoOverlay.testDefaultValues() {
        assertNull(content)
        assertNull(text)
    }
}
