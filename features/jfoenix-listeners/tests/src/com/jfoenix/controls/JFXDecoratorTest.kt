package ktfx.jfoenix.listeners

import com.jfoenix.controls.JFXDecorator
import ktfx.jfoenix.test.BaseJFXDecoratorTest

class JFXDecoratorTest : BaseJFXDecoratorTest() {

    override fun JFXDecorator.callOnCloseButtonAction(action: () -> Unit) =
        onCloseButtonAction(action)
}