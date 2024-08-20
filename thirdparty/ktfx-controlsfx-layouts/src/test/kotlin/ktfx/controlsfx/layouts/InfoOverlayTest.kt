package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.Region
import ktfx.layouts.KtfxPane
import ktfx.layouts.region
import org.controlsfx.control.InfoOverlay
import kotlin.test.Test
import kotlin.test.assertIs
import kotlin.test.assertNull

class InfoOverlayTest : LayoutsStyledTest<KtfxPane, InfoOverlay>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = infoOverlay {}

    override fun KtfxPane.child2() = infoOverlay()

    override fun child3() = styledInfoOverlay()

    override fun KtfxPane.child4() = styledInfoOverlay()

    override fun InfoOverlay.testDefaultValues() {
        assertNull(content)
        assertNull(text)
    }

    @Test
    fun add() {
        infoOverlay {
            region()
            assertIs<Region>(content)
        }
    }
}
