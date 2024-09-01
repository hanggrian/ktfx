package ktfx.jfoenix.dialogs

import com.hanggrian.ktfx.test.DialogShowingTest
import javafx.scene.control.ButtonType.CLOSE
import javafx.util.Callback
import ktfx.dialogs.buttons
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import ktfx.dialogs.icon
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class JfxAlertTest : DialogShowingTest() {
    @Test
    fun jfxAlert() {
        interact {
            assertEquals(
                "Close",
                stage
                    .jfxAlert<String> {
                        headerTitle = "Jfoenix alert"
                        graphicIcon = sampleGraphic

                        setOnShown { close() }
                        assertEquals("Jfoenix alert", headerText)
                        assertEquals("Jfoenix alert", title)
                        assertEquals(sampleGraphic, graphic)
                        assertEquals(sampleGraphic.image, icon)
                        buttons.add(CLOSE)
                        resultConverter = Callback { it.text }
                    }.get(),
            )
        }
    }
}
