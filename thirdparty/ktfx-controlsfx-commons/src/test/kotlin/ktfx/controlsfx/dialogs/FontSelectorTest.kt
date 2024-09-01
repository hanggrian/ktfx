package ktfx.controlsfx.dialogs

import com.hanggrian.ktfx.test.DialogShowingTest
import javafx.scene.text.Font
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import ktfx.dialogs.icon
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class FontSelectorTest : DialogShowingTest() {
    private val arial18 = Font.font("Arial", 18.0)

    @Test
    fun exceptionDialog() {
        interact {
            assertEquals(
                arial18,
                fontSelector(arial18) {
                    headerTitle = "Font selector"
                    graphicIcon = sampleGraphic

                    closeOnShow(this)
                    assertEquals("Font selector", headerText)
                    assertEquals("Font selector", title)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals(sampleGraphic.image, icon)
                }.get(),
            )
            assertEquals(arial18, fontSelector(arial18) { closeOnShow(this) }.get())
        }
    }
}
