package ktfx.jfoenix.dialogs

import ktfx.dialogs.buttons
import ktfx.test.DialogShowingTest
import ktfx.callbackOf
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class JFXAlertsTest : DialogShowingTest() {

    @Test fun jfxAlert() {
        interact {
            assertEquals("Close", stage.jfxAlert<String>("Jfoenix alert", sampleGraphic) {
                setOnShown { close() }
                assertEquals("Jfoenix alert", title)
                assertEquals(sampleGraphic, graphic)
                buttons.close()
                resultConverter = callbackOf { it.text }
            }.get())
        }
    }
}