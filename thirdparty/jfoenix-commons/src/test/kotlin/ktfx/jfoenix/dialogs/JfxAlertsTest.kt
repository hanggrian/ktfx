package ktfx.jfoenix.dialogs

import com.hendraanggrian.ktfx.test.DialogShowingTest
import javafx.scene.control.ButtonType.CLOSE
import ktfx.callbackOf
import ktfx.dialogs.buttons
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class JfxAlertsTest : DialogShowingTest() {
    @Test
    fun jfxAlert() {
        interact {
            assertEquals(
                "Close",
                stage.jfxAlert<String>("Jfoenix alert", sampleGraphic) {
                    setOnShown { close() }
                    assertEquals("Jfoenix alert", title)
                    assertEquals(sampleGraphic, graphic)
                    buttons.add(CLOSE)
                    resultConverter = callbackOf { it.text }
                }.get()
            )
        }
    }
}
