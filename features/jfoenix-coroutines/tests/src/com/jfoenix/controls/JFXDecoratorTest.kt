package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDecorator
import kotlinx.coroutines.Dispatchers
import ktfx.jfoenix.test.BaseJFXDecoratorTest

class JFXDecoratorTest : BaseJFXDecoratorTest() {

    override fun JFXDecorator.callOnCloseButtonAction(action: () -> Unit) =
        onCloseButtonAction(Dispatchers.Unconfined) { action() }
}