package ktfx.jfoenix.listeners

import com.jfoenix.controls.JFXDecorator
import ktfx.jfoenix.test.BaseJFXDecoratorTest

class JfxDecoratorTest : BaseJFXDecoratorTest() {
    override fun JFXDecorator.callOnCloseButtonAction(action: () -> Unit): Unit =
        onCloseButtonAction(action)
}
