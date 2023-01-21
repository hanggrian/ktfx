package ktfx.controlsfx.dialogs

import com.hendraanggrian.ktfx.test.DialogShowingTest
import javafx.scene.text.Font
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class FontSelectorsTest : DialogShowingTest() {
    private val arial18 = Font.font("Arial", 18.0)

    @Test
    fun exceptionDialog() {
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
