package ktfx.dialogs

import com.hanggrian.ktfx.test.DialogShowingTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class InputDialogsTest : DialogShowingTest() {
    @Test
    fun inputDialog() {
        interact {
            assertEquals(
                "Awesome input",
                inputDialog("Awful input") {
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
