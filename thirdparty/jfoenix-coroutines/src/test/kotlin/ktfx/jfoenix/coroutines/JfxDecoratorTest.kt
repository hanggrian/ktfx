package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDecorator
import kotlinx.coroutines.Dispatchers
import ktfx.jfoenix.test.BaseJFXDecoratorTest

class JfxDecoratorTest : BaseJFXDecoratorTest() {
    override fun JFXDecorator.callOnCloseButtonAction(action: () -> Unit): Unit =
        onCloseButtonAction(Dispatchers.Unconfined) { action() }
}
