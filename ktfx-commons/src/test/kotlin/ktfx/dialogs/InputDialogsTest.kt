package ktfx.dialogs

import com.hendraanggrian.ktfx.test.DialogShowingTest
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
                inputDialog("Input dialog", sampleGraphic, "Awful input") {
                    closeOnShow(this)
                    assertEquals("Input dialog", headerText)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals("Awful input", defaultValue)
                    editor.text = "Awesome input"
                }.get(),
            )
            assertEquals(
                "Awesome input",
                inputDialog("Awful input") {
                    closeOnShow(this)
                    assertEquals("Awful input", defaultValue)
                    editor.text = "Awesome input"
                }.get(),
            )
        }
    }
}
