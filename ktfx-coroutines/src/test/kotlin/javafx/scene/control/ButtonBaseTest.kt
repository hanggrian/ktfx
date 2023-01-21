package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseButtonBaseTest
import javafx.event.ActionEvent
import javafx.scene.control.ButtonBase
import kotlinx.coroutines.Dispatchers

class ButtonBaseTest : BaseButtonBaseTest() {
    override fun ButtonBase.callOnAction(action: (ActionEvent) -> Unit) =
        onAction(Dispatchers.Unconfined) { action(it) }
}
