package ktfx.dialogs

import com.hanggrian.ktfx.test.DialogShowingTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class TextInputDialogTest : DialogShowingTest() {
    @Test
    fun textInputDialog() {
        interact {
            assertEquals(
                "Awesome input",
                textInputDialog("Awful input") {
                    headerTitle = "Input dialog"
                    graphicIcon = sampleGraphic

                    closeOnShow(this)
                    assertEquals("Input dialog", headerText)
                    assertEquals("Input dialog", title)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals(sampleGraphic.image, icon)
                    assertEquals("Awful input", defaultValue)
                    editor.text = "Awesome input"
                }.get(),
            )
        }
    }
}
