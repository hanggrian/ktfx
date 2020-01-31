package ktfx.controlsfx.dialogs

import javafx.scene.text.Font
import ktfx.test.DialogShowingTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class FontSelectorTest : DialogShowingTest() {

    private val arial18 = Font.font("Arial", 18.0)

    @Test fun exceptionDialog() {
        interact {
            assertEquals(
                arial18,
                fontSelector("Font selector", sampleGraphic, arial18) {
                    closeOnShow(this)
                    assertEquals("Font selector", headerText)
                    assertEquals(sampleGraphic, graphic)
                }.get()
            )
            assertEquals(arial18, fontSelector(arial18) { closeOnShow(this) }.get())
        }
    }
}