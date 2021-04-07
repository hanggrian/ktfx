package ktfx.controlsfx.dialogs

import javafx.scene.control.ButtonType
import com.hendraanggrian.ktfx.test.DialogShowingTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class ExceptionDialogsTest : DialogShowingTest() {

    @Test fun exceptionDialog() {
        interact {
            assertEquals(
                ButtonType.OK,
                exceptionDialog("Exception dialog", sampleGraphic, UnsupportedOperationException()) {
                    closeOnShow(this)
                    assertEquals("Exception dialog", headerText)
                    assertEquals(sampleGraphic, graphic)
                }.get()
            )
            assertEquals(ButtonType.OK, exceptionDialog(UnsupportedOperationException()) {
                closeOnShow(this)
            }.get())
        }
    }
}