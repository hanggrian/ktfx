package ktfx.controlsfx.dialogs

import com.hendraanggrian.ktfx.test.DialogShowingTest
import javafx.scene.control.ButtonType.OK
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class ExceptionDialogsTest : DialogShowingTest() {
    @Test
    fun exceptionDialog() {
        interact {
            assertEquals(
                OK,
                exceptionDialog(
                    "Exception dialog",
                    sampleGraphic,
                    UnsupportedOperationException(),
                ) {
                    closeOnShow(this)
                    assertEquals("Exception dialog", headerText)
                    assertEquals(sampleGraphic, graphic)
                }.get(),
            )
            assertEquals(
                OK,
                exceptionDialog(UnsupportedOperationException()) { closeOnShow(this) }.get(),
            )
        }
    }
}
